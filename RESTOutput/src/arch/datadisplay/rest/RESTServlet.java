package arch.datadisplay.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arch.dataaggregate.IDataAggregate;

public class RESTServlet extends HttpServlet {

    /**
	 * 
	 */
    private static final long serialVersionUID = 590808281763644925L;
    
    private IDataAggregate dataAggregateService = null;
    
    protected void setDataAggregateService(IDataAggregate da) {
    	dataAggregateService = da;
    }

    protected void unsetDataAggregateService(IDataAggregate da) {
    	dataAggregateService = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	StringBuilder buffer = new StringBuilder(200);
        PrintWriter writer = resp.getWriter();

        List<List<String>> list1 = dataAggregateService.getData(req.getParameter("type"));

        for(int i = 0; i < list1.size(); i++) {
        	List<String> row = list1.get(i);
        	for(int j = 0; j < row.size(); j++) {
        		buffer.append(row.get(j) + "\t");
        	}
        	buffer.append("\n");
        }
        writer.write(buffer.toString());
    }
}
