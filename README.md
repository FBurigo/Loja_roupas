**O QUE FAZER:**
>Desenvolver uma API RESTful (back-end) utilizando Springboot para Gestão de Loja de Roupas.

**entidades:**
>Cliente: id, nome, cpf, idade e telefone.<br>
>Funcionário: id, nome, idade e matrícula.<br>
>Venda: id, endereço da entrega e valor total.<br>
>Produto: id, nome e valor.<br>

**Relacionamentos:**
>Um cliente pode realizar várias compras, ou seja, pode estar vinculado a várias vendas, mas uma venda só pode estar associada a um cliente.<br>
>Um funcionário pode realizar várias vendas, mas uma venda só pode estar associada a um funcionário.<br>
>Uma venda pode ter vários produtos e um produto pode estar vinculado em várias vendas.<br>

**Regras de negócio e validações:**
>A entidade principal é Venda. O sistema deve permitir salvar a venda com o cliente, o funcionário e os produtos em uma única requisição (cascade).<br>
>Todos os atributos das entidades são obrigatórios, exceto endereço de entrega (validation).<br>
>Além de métodos básicos de CRUD (findAll, findById, delete, save e update), implementar ao menos 3 filtros (findBy...), sendo 01 com JPQL e 02 com métodos automáticos para cada repository de cada uma das 4 entidades.<br>
>Todas as entidades devem possuir endpoints, então, haverá controller, service, repositor para cada entidade.<br>

**Postman:**
>https://www.postman.com/technical-geoscientist-72975412/workspace/lojaroupas/collection/37364162-e28f3186-8a6e-45df-8770-6fdd4c7e7939?action=share&creator=37364162
