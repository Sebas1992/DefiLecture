<!--
    This file is part of DefiLecture.

    DefiLecture is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    DefiLecture is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with DefiLecture.  If not, see <http://www.gnu.org/licenses/>.
-->
<%-- 
    Document   : gestionModificationLecture
    Created on : 2017-10-24, 08:11:17
    Author     : Charles
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.defiLecture.modele.Lecture"%>
<%@page import="com.defiLecture.modele.LectureDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.Config"%>
<%@page import="jdbc.Connexion"%>
<% 
    Connexion.reinit();
    Connection cnx = Connexion.startConnection(Config.DB_USER, Config.DB_PWD, Config.URL, Config.DRIVER);
    LectureDAO dao = new LectureDAO(cnx);
    Lecture l = dao.read(request.getParameter("id"));
    pageContext.setAttribute("l", l);
  %>


    <body>
        <h1>Modification de la lecture</h1>
        <form action="*.do" method="post">
            <div>
                Titre* : <input type="text" name="titre" value="${l.titre}" required />
            </div>
            <div>
                Dur�e de la lecture (en minutes)* : <input type="text" name="dureeMinutes" value="${l.dureeMinutes}" required />
            </div>
            <div>
                <br>
                La lecture �tait-elle obligatoire?
                <c:choose>
                    <c:when test="${l.estObligatoire eq 1}">
                     <div class="radio">
                        <label><input type="radio" checked name="obligatoire" value="1" required >oui</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="obligatoire" value="0" required >non</label>
                    </div>
                    </c:when>
                    <c:otherwise>
                        <div class="radio">
                            <label><input type="radio" name="obligatoire" value="1" required >oui</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" checked name="obligatoire" value="0" required >non</label>
                        </div>
                        
                    </c:otherwise>
                    
                </c:choose>
                
            </div>
           
            <div>
            <input type="hidden" name="idLecture" value="${l.idLecture}">
            <input type="hidden" name="tache" value="effectuerModificationLecture">
                <input type="submit" name="modifie" value=" Enregistrer" />
                <input type="submit" name="annule" value=" Annuler" />
            </div>
        </form>
        
        
        
        
    </body>

