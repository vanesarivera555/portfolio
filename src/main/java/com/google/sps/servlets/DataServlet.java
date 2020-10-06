// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
private ArrayList<String> messeges;
//public void init(){
//messeges = new ArrayList<String>();

  //  messeges.add("Testing Comment1");
 //   messeges.add("Testing comment2");
 //   messeges.add("Testing comment3");
//}
int count;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     response.setContentType("application/json");
      messeges.add("Testing Comment1");
       String json = convertToJson(messeges, count);
    //response.setContentType("text/html;");
    //response.getWriter().println("<h1>Hello Vanesa!</h1>");
  ArrayList<String> messeges = new ArrayList<String>();
  
   
   // String json = convertToJsonUsingGson(messeges);
   // Gson gson = new Gson();
   // String json = gson.toJson(messeges);
   
    response.getWriter().println(json);

  }

@Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
    String newComments = getParameter(request, "text-input", "");
    messeges.add("Entered Comments: "+ newComments);
    count++;
    response.sendRedirect("/index.html");

    }

 private String convertToJson(ArrayList<String> messeges, int size) {
    String json = "{";
    if (size ==0){
        json +="\"Comment\": ";
        json += "\"" + messeges.get(0) + "\"";
        json += "}";
        
  }
  return json;
}
  private String convertToJsonUsingGson(ArrayList<String> messeges){
      Gson gson = new Gson();
      String json = gson.toJson(messeges);
      return json;
  }
   private String getParameter(HttpServletRequest request, String messeges, String count) {
    String messegess = request.getParameter(count);
    if (count == null) {
      return count;
    }
    return count;
  }

}
