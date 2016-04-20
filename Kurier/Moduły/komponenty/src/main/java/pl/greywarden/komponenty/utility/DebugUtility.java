package pl.greywarden.komponenty.utility;

public class DebugUtility {

    public static String createHTMLTableFromExceptionStack(Exception e) {
        StringBuilder builder = new StringBuilder();
        builder.append("<table border=\"2\">");
        builder.append("<tr><td>").append(e.getLocalizedMessage()).append("</td></tr>");
        builder.append("<tr><td>Klasa</td><td>Numer linii</td><td>Nazwa metody</td></tr>");
        for (StackTraceElement element : e.getStackTrace()) {
            String[] data = {element.getClassName(), element.getLineNumber() + "", element.getMethodName()};
            builder.append(String.format("<tr>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "<td>%s</td>"
                    + "</tr>",
                    (Object[]) data));
        }
        return builder.append("</table>").toString();
    }
}
