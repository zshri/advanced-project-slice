
create sequence my_sequence
    start with 1000
    increment by 10;

create table post
(
    id          bigserial
        primary key,
    author      varchar(255),
    content     varchar(15940),
    create_at   timestamp,
    post_status varchar,
    title       varchar(255),
    update_at   timestamp
);


INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (1, 'Principal', 'Cloud-native technology has been changing the way payment services are architected. In 2020, I presented a series of insights from real implementations adopting open-source and cloud-native technology to modernize payment services.
The series consisted of six articles and covered architectural diagrams from logical, schematic, and detailed views of the various use cases uncovered.
The architectures presented were based on open-source cloud-native technologies, such as containers, microservices, and a Kubernetes-based container platform. The major omission in this series was to avoid discussing any aspect of cloud-native observability. This series will take a look at fixing that omission with an open-source, standards-based, cloud-native observability platform that helps DevOps teams control the speed, scale, and complexity of a cloud-native world for their financial payments architecture.
Part one covered the baseline architecture, defined the payments project, and shared the planning for this series in adding observability to the logical and physical architectures. Part two explored the common architectural elements needed when adding cloud-native observability to your financial payments solutions (links for Parts 1 and 2 in the "Series Overview" section at the end of this article). In this article, we''ll walk through a financial payments physical architecture, exploring how to add scalable cloud-native observability and laying out the various deployment options you have for your payments observability solution.
', '2023-08-12 19:50:09.038517', 'PUBLISH', 'Observability Architecture: Financial Payments Example', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (2, 'Principal', 'Cloud-native technology has been changing the way payment services are architected. In 2020, I presented a series of insights from real implementations adopting open-source and cloud-native technology to modernize payment services.
The series consisted of six articles and covered architectural diagrams from logical, schematic, and detailed views of the various use cases uncovered.
The architectures presented were based on open-source cloud-native technologies, such as containers, microservices, and a Kubernetes-based container platform. The major omission in this series was to avoid discussing any aspect of cloud-native observability. This series will take a look at fixing that omission with an open-source, standards-based, cloud-native observability platform that helps DevOps teams control the speed, scale, and complexity of a cloud-native world for their financial payments architecture.
Part one covered the baseline architecture, defined the payments project, and shared the planning for this series in adding observability to the logical and physical architectures. Part two explored the common architectural elements needed when adding cloud-native observability to your financial payments solutions (links for Parts 1 and 2 in the "Series Overview" section at the end of this article). In this article, we''ll walk through a financial payments physical architecture, exploring how to add scalable cloud-native observability and laying out the various deployment options you have for your payments observability solution.
', '2023-08-12 19:51:10.868810', 'PUBLISH', 'Observability Architecture: Financial Payments Example', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (3, 'Principal', 'Most methodology discussions today start and end with how Agile is superior to Waterfall in software engineering; in reality, many other methodologies exist, each with their own pros and cons. Leadership, enamored with being agile, insist on Agile — or at least the perception of — even when another methodology is more appropriate for the project, team, business domain, customer, whatever.
I view the bigger problem as methodology for methodology''s sake: application without understanding, execution without adaptation. Thou shall do X as defined by said methodology, and so you shall regardless of lack of perceived benefits.
A previous employer created a template to calculate planned hours for the project stages — design, implementation, testing, integration, deployment, documentation, etc. — based on supporting values provided. My project was already implementing before planning was completed — yes, I know — but the project manager insisted on completing the template. Unfortunately, the planned hours generated were different with actuals for completed tasks, sometimes substantially. The project manager had no discretion to deviate and stipulated that planned hours were correct despite our protestations. Subsequently, the team ignored the plan and just completed the work.
This story and a recent visit to a museum (really!) had me considering other ways I''ve seen or heard of projects being managed.
', '2023-08-12 19:52:02.617594', 'PUBLISH', 'Non-Traditional Project Planning', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (4, 'Principal', 'To demonstrate Pinia’s features, we’ll build a basic blog engine with the following features:
A list of all posts A single post page with the post’s comments A list of all post authors A single author page with the author’s written posts
First, let’s create a new Vue project by running the following command:', '2023-08-12 19:53:09.965042', 'PUBLISH', 'Getting started with Pinia', null);
