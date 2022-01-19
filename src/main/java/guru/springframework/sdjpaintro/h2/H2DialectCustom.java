package guru.springframework.sdjpaintro.h2;

import org.hibernate.dialect.H2Dialect;

import java.sql.Types;

public class H2DialectCustom extends H2Dialect {

    public H2DialectCustom(){
        super();
        registerColumnType(Types.BINARY,"varbinary");
        System.out.println("Inside H2DialectCustom");
    }
}
