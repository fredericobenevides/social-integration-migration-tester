# Social Integration Migration Tester

Ferramenta local para testar e validar uma migração de integrações com redes sociais e outras fontes externas.

O projeto executa consultas equivalentes nas implementações antiga e nova, compara os resultados retornados e ajuda a identificar diferenças de comportamento ou regressões introduzidas durante a migração.

## Estrutura

- `core-antigo/`: API da implementação anterior usada como referência.
- `core-novo/`: API da implementação migrada que será comparada.
- `core/`: API coordenadora; chama as duas implementações e compara os resultados.
- `web/`: interface React para cadastrar serviços e acionar comparações.
- `docker/`: inicialização do PostgreSQL para desenvolvimento local.

## Tecnologias

- Kotlin e Spring Boot
- React
- PostgreSQL
- Docker Compose

## Projeto sanitizado

Este repositório é uma versão sanitizada e independente de um projeto originalmente usado em ambiente interno.

Foram removidos ou substituídos:

- tokens, chaves, refresh tokens e credenciais de acesso;
- identificadores de contas, páginas, localizações e tags específicos;
- referências de nome presentes nos packages e artefatos Maven.

Use apenas contas e credenciais de teste. Nunca adicione valores reais ao Git.

## Configuração de credenciais locais

O módulo `core` lê as credenciais de integração por variáveis de ambiente. Use o arquivo de exemplo como referência:

```bash
cp .env.example .env
```

Preencha o `.env` com valores de teste. O Docker Compose ou o ambiente de execução deve carregar essas variáveis antes de iniciar os serviços.

As principais configurações são:

- `MIGRATION_TESTER_FACEBOOK_DEFAULT_PAGE_ACCESS_TOKEN`
- `MIGRATION_TESTER_FACEBOOK_ADS_PAGE_ACCESS_TOKEN`
- `MIGRATION_TESTER_FACEBOOK_TAGGED_PAGE_ACCESS_TOKEN`
- `MIGRATION_TESTER_INSTAGRAM_ACCESS_TOKEN`
- `MIGRATION_TESTER_GOOGLE_MY_BUSINESS_REFRESH_TOKEN`

## Execução local

### Pré-requisitos

- Docker e Docker Compose;
- Java compatível com os módulos Spring Boot;
- Node.js e npm;
- dependências Maven necessárias para os módulos `core-antigo` e `core-novo`.

### Iniciar os serviços

```bash
docker compose up --build
```

Depois, a interface web fica disponível em `http://localhost:3000`.

## Limitações conhecidas

Os módulos `core-antigo` e `core-novo` preservam a estrutura original e dependem de artefatos Maven que não são distribuídos neste repositório. Por esse motivo, uma execução completa requer que essas dependências estejam disponíveis no ambiente local.

Além disso, os resultados dependem da disponibilidade, permissões e políticas das APIs externas integradas.

## Segurança

- Não versione `.env` ou arquivos com credenciais.
- Utilize somente tokens e contas de teste.
- Revogue imediatamente qualquer credencial publicada por acidente.
- Revise logs, exemplos, screenshots e pull requests antes de compartilhá-los.

## Licença

Nenhuma licença foi definida ainda. Escolha uma licença antes de publicar o repositório.
