CREATE OR REPLACE FUNCTION fn_customer_total_spent(p_customer_id UUID)
RETURNS DECIMAL
LANGUAGE plpgsql
AS $$
DECLARE
    v_total DECIMAL := 0;
BEGIN
    SELECT COALESCE(SUM(p.amount), 0)
    INTO v_total
    FROM payment p
    JOIN invoice i ON i.id = p.invoice_id
    WHERE i.customer_id = p_customer_id
      AND p.status = 'paid';

    RETURN v_total;
END;
$$;

-- Uso:
-- SELECT fn_customer_total_spent('uuid-del-cliente');