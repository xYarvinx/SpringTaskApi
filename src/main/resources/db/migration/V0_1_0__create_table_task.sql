CREATE TABLE "task"
(
    id bigserial,
    title varchar(40),
    text varchar(255),
    done boolean,
    CONSTRAINT pr_id PRIMARY KEY (id)
)