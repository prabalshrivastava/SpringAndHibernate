delimeter $$
create procedure sp_books_in_range(p_min DOUBLE,p_max DOUBLE)
BEGIN
    select * from books where price between p_min and p_max;
END;
$$


delimeter $$
create procedure sp_get_book_price(IN p_id int,OUT p_price DOUBLE)
BEGIN
    select price into p_price from books where id=p_id;
END;
$$

DELIMITER ;

CALL sp_get_book_price(11, @result);
SELECT @result;