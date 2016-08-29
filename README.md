#Uwagi na temat technologii JSP:
- strona główna to index.jsp
- wszystko pisze się normalnie w HTML i CSS
- znaczniki:
 - <% otwierający i %> zamykający - pomiędzy nimi wywoływany jest kod Java, działanie podobne do znacznika <?php
 - <%= zmienna %> działa analogicznie, jak <?php echo zmienna; ?> -> wyrzuca na stronę zawartość zmiennej
 - <%@ page import="..."%> -> importuje pakiet dodany do projektu; umożliwia korzystanie z dostępnych w obrębie pakietu klas i metod
- każda kolejna strona powinna zawierać następujący nagłówek: <b><i><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%></i></b> - by zagwarantować poprawne kodowanie polskich znaków
#Uwagi dotyczące implementacji front-endu:
Serwer docelowy to JBoss, ale nie ma to znaczenia dla samej implementacji strony. Każda strona powinna być w podkatalogu i zawarta w pliku <b>index.jsp</b>. Do ogarnięcia będzie kilka spraw:
- zmienna <i>session</i>
 - <i>getAttribute("nazwa")</i> - zwraca obiekt będący reprezentacją ustawionego atrybutu lub null, jeżeli nie został on ustawiony - zwraca obiekt, więc trzeba go przetworzyć, by móc wykorzystać, o czym niżej
 - <i>setAttribute("nazwa",wartość)</i> - ustawia atrybut sesji o podanej nazwie i własności, na przykład <b>session</b>.<i>setAttribute("loggedIn",true)</i>;
#Przetwarzanie obiektu na zmienne
Metoda <i>getAttribute("nazwa")</i> zwraca obiekt, który jest typem nadrzędnym. Metody konwersji:
 - <b>boolean</b> - boolean flaga = new Boolean(session.getAttribute("nazwa")+"").booleanValue();
 - <b>String</b> - String napis = session.getAttribute("nazwa").toString();
 - <b>int</b> - int liczba = Integer.parseInt(session.getAttribute("nazwa")+"").intValue();
 - <b>double</b> - double liczba = Double.parseDouble(session.getAttribute("nazwa")+"").doubleValue();

**UWAGA**
**Jeżeli <b>session.getAttribute(...)</b> zwróci null, to parsowanie do typów pierwotnych (<i>int, float, double</i>) się nie powiedzie i rzuci wyjątek IllegalArgumentException! Przed parsowaniem trzeba sprawdzić, czy konwertowany obiekt nie jest <b>null</b>!**

Dodatkowe info wrzucę na dniach.
*Peace*
