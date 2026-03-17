CREATE OR REPLACE VIEW vw_order_summary AS
SELECT
    o.id                                         AS order_id,
    o.order_date,
    o.status                                     AS order_status,
    o.total                                      AS order_total,

    -- Cliente
    CONCAT(pc.first_name, ' ', pc.last_name)     AS customer_name,
    pc.email                                     AS customer_email,
    c.customer_type,

    -- Usuario que gestionó la orden
    u.username                                   AS managed_by,

    -- Conteo de ítems
    COUNT(oi.id)                                 AS item_count

FROM "order" o
JOIN customer  c  ON c.id  = o.customer_id
JOIN person    pc ON pc.id = c.person_id
JOIN "user"    u  ON u.id  = o.user_id
LEFT JOIN order_item oi ON oi.order_id = o.id

GROUP BY
    o.id, o.order_date, o.status, o.total,
    pc.first_name, pc.last_name, pc.email,
    c.customer_type, u.username;