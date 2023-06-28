#!/bin/bash

IMPORT_FLAG_FILE=/opt/keycloak/imported.flag

if [[ -z "${KEYCLOAK_IMPORT}" ]]; then
  echo "Skipping Import (KEYCLOAK_IMPORT not used)"
else
  if test -f "$IMPORT_FLAG_FILE"; then
      echo "Skipping Import (already imported)"
  else
      echo "Import initial config: $KEYCLOAK_IMPORT)"
      /opt/keycloak/bin/kc.sh import --file "$KEYCLOAK_IMPORT"
      touch "$IMPORT_FLAG_FILE"
  fi
fi

echo "Starting Keycloak ... "
/opt/keycloak/bin/kc.sh "$@"


docker run --name keycloak_unoptimized -p 8080:8080 \
        -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=change_me \
        -v "$(pwd)"/realm-export.json:/opt/keycloak/data/import/realm.json \
        quay.io/keycloak/keycloak:latest \
        start-dev --import-realm

kubectl create secret generic keycloak-db-secret \
  --from-literal=username=keycloak \
  --from-literal=password=testpassword


openssl req -subj '/CN=test.keycloak.org/O=Test Keycloak./C=US' -newkey rsa:2048 -nodes -keyout key.pem -x509 -days 365 -out certificate.pem

kubectl get pods

openssl genrsa -out ca_key.pem 2048
openssl req -new -x509 -days 3650 -key ca_key.pem -out ca.crt

kubectl create secret tls example-tls-secret --cert ca.crt --key ca_key.pem
