package br.com.devdojo.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component //Marca esta classe para ser scanneada pelo ComponentScan da classe ApplicationStart
//@Repository Especialização do Component quando se estiver usando DAO
//@Service Especialização do Component mas não faz nada para o component, deve ser usada em classes de serviço

public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
    return DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss").format(localDateTime);
    }
}