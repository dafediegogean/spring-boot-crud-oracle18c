create or replace procedure sp_lista_marcas
    (
        OUT_CURSOR      out SYS_REFCURSOR
    )
    is
    begin
        begin
            open OUT_CURSOR for
            select  marca.marca_id, 
                    marca.nome,
                    marca.data_fundacao
            from marca;
        exception
            when no_data_found then
                return;
            when others then
                close out_cursor;
                raise_application_error(-20101, 'Ocorreu um erro: '||sqlcode||' - '||sqlerrm);
            end;
end sp_lista_marcas;
