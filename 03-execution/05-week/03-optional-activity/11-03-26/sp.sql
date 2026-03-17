CREATE OR REPLACE PROCEDURE sp_create_invoice_from_order(
    p_order_id      UUID,
    p_invoice_number VARCHAR(255)
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_invoice_id  UUID;
    v_customer_id UUID;
    v_total       DECIMAL;
    v_item        RECORD;
BEGIN
    -- Obtener datos de la orden
    SELECT customer_id, total
    INTO v_customer_id, v_total
    FROM "order"
    WHERE id = p_order_id;

    IF NOT FOUND THEN
        RAISE EXCEPTION 'Orden con id % no encontrada.', p_order_id;
    END IF;

    -- Crear la factura
    INSERT INTO invoice (order_id, customer_id, invoice_number, issue_date, total)
    VALUES (p_order_id, v_customer_id, p_invoice_number, NOW(), v_total)
    RETURNING id INTO v_invoice_id;

    -- Copiar ítems de order_item → invoice_item
    FOR v_item IN
        SELECT oi.product_id, oi.unit_price
        FROM order_item oi
        WHERE oi.order_id = p_order_id
    LOOP
        INSERT INTO invoice_item (invoice_id, product_id, quantity, unit_price)
        VALUES (v_invoice_id, v_item.product_id, 1, v_item.unit_price);
    END LOOP;

    RAISE NOTICE 'Factura % creada con id: %', p_invoice_number, v_invoice_id;
END;
$$;

-- Uso:
-- CALL sp_create_invoice_from_order('uuid-orden', 'FAC-2026-001');