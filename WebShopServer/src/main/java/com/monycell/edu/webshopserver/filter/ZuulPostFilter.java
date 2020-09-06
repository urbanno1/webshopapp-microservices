package com.monycell.edu.webshopserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletResponse;

public class ZuulPostFilter extends ZuulFilter {
   @Override
    public String filterType() {
       return "post";
   }

   @Override
    public int filterOrder() {
       return 1;
   }

   @Override
    public boolean shouldFilter() {
       return true;
   }

   @Override
    public Object run() throws ZuulException {
       RequestContext ctx = RequestContext.getCurrentContext();

       HttpServletResponse response = ctx.getResponse();
       response.addHeader("Monycell", "One Billion Dollars");

       System.out.println("Status: " + response.getStatus() + "\n" + "Headers: " + response.getHeader("Monycell"));

       return null;
   }
}
