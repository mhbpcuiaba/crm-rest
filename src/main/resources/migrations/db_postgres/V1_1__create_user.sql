
/*
cira o arquivo de migracao na mao msm!!!
  mvn flyway:baseline
  mvn flyway:info
  mvn flyway:migrate
  mvn flyway:clean
 */

CREATE TABLE IF NOT EXISTS "crm".users (
  id BIGSERIAL PRIMARY KEY,
	version BIGINT NOT NULL,
	name VARCHAR(50) NOT NULL ,
	email VARCHAR(70) UNIQUE NOT NULL,
	birthday DATE NOT NULL,
	phone VARCHAR(15),
	creation_time TIMESTAMP NOT NULL,
	modification_time TIMESTAMP,
	user_mgmt_id BIGINT NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE
);




CREATE SEQUENCE "crm".users_seq
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "crm".users ALTER COLUMN id SET DEFAULT nextval('"crm".users_seq');

ALTER SEQUENCE "crm".users_seq OWNED BY "crm".users.id;

INSERT INTO "crm".users (version, name, email, birthday, phone, creation_time, user_mgmt_id)
SELECT 1,'Marcos Henrique Barros Pinto', 'marcoscba@gmail.com', to_date('27/07/1982','DD/MM/YYYY'), '11985733131', NOW(),1
WHERE NOT EXISTS (
   SELECT 1 FROM "crm".users WHERE email = 'marcoscba@gmail.com'
);