# Entendendo o ODS 12: Produção e Consumo Sustentáveis

O ODS 12 visa garantir padrões de produção e consumo sustentáveis. No contexto da coleta de lixo, esse objetivo se relaciona diretamente com a redução, reutilização e reciclagem de materiais, minimizando o impacto ambiental dos resíduos.

## Desafios e Solução Tecnológica

Os principais desafios relacionados à coleta de lixo são:

- Falta de informação: Muitos cidadãos não sabem os dias e horários corretos da coleta seletiva em suas regiões.
- Dificuldade na separação: A falta de conhecimento sobre o que pode ou não ser reciclado dificulta a separação correta dos resíduos.
- Baixa adesão: A falta de incentivos e a complexidade do processo de reciclagem muitas vezes desmotivam as pessoas a participarem.

Solução: Um aplicativo Android que fornece um calendário personalizado de coleta seletiva, informações sobre os materiais recicláveis e recursos educacionais pode ser uma ferramenta poderosa para aumentar a conscientização e participação dos cidadãos.

### Etapas:

- Brainstorm
- Design Thinking
- UML
- Prototipação
- Desenvolvimento com código

### Documentação
[Projeto](https://github.com/giseletoledo/ColetaCerta)

[Apresentação](https://github.com/giseletoledo/ColetaCerta)

[Protótipo no figma](https://github.com/giseletoledo/ColetaCerta)

[Teste de cadastro em telas](https://github.com/giseletoledo/ColetaCerta)

## Commits Guideline

Nós possuimos regras e padrões sobre como as nossas mensagens de commit devem ser formatadas. Isso nós oferece uma
melhor experiência na hora de acompaharmos o history do projeto.

Utilizamos o padrão de [conventional commits](https://www.conventionalcommits.org/), logo todos os commits neste
repositório deverão seguir essa convenção.

### Formato do Commit

Cada mensagem de commit pode conter um **header**, um **body** e um **footer**. O header possui um formato especial
que pode conter um **type**, uma **task** (task ou história do jira) e um **subject**.

```
<type>(<task>): <subject>
<body>
<footer>
```

O **type** e o **subject** são obrigatórios.

Exemplo:

`docs: change README about CICD`

### Tipos de Commits

| Tipo    | Função                                                                      |
| ------- | --------------------------------------------------------------------------- |
| _feat_  | Uma nova implementação / feature                                            |
| _build_ | Modificações que afetam as ferramentas de build                             |
| _ci_    | Modificações nos arquivos e nos scripts de configuração de CI               |
| _docs_  | Modificações em documentações e afins                                       |
| _fix_   | Correção de um bug                                                          |
| _perf_  | Modificações de código para otimizar performance                            |
| _impr_  | Modificações que não necessariamente é um fix ou nova feature               |
| _style_ | Mudanças que não modifiquem lógica (white-space, formatting, prettier, etc) |
| _test_  | Testes que foram adicionados ou corrigidos                                  |
| _chore_ | Uma modificação geral que não se enquandra em nenhum outro padrão           |