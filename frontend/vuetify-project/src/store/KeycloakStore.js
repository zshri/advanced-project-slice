import { defineStore } from 'pinia'
import  Keycloak from "keycloak-js";

let initOptions = {
  url: 'http://localhost:8081/auth',
  realm: 'advanced-project-realm',
  clientId: 'vue-client',
  onLoad: 'login-required',
}

export const useKeycloakStore = defineStore('KeycloakStore', {
  state: () => ({
    keycloak: null,
    token: null,
    userInfo: null
  }),
  actions: {
    async init() {
      const keycloak = Keycloak(initOptions);
      await keycloak.init({ onLoad: 'login-required' });
      const token = keycloak.token;
      this.keycloak = keycloak;
      this.userInfo = keycloak.userInfo;
      this.token = token;
    },
  },
});



