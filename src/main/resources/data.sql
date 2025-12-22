delete from ingredient_ref;
delete from taco;
delete from taco_order;

delete from ingredient;

insert into ingredient
            values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into ingredient
            values ('COTO', 'Corn Tortilla', 'WRAP');
insert into ingredient
            values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into ingredient
            values ('CARN', 'Carnitas', 'PROTEIN');
insert into ingredient
            values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into ingredient
            values ('LETC', 'Lettuce', 'VEGGIES');
insert into ingredient
            values ('CHED', 'Cheddar', 'CHEESE');
insert into ingredient
            values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into ingredient
            values ('SLSA', 'Salsa', 'SAUCE');
insert into ingredient
            values ('SRCR', 'Sour Cream', 'SAUCE');
