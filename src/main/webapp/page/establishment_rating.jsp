<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 14/10/2018
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <br> <br> <br> <br>
    <h4 class="text-center hidden-xs">Avalie</h4>
    <form method="post" action="/front?action=AvaliarEstabeleciment">
        <fieldset class="rating">
            <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Incrível - 5 estrelas"></label>
            <input type="radio" id="star4half" name="rating" value="4.5" /><label class="half" for="star4half" title="Muito bom - 4.5 estrelas"></label>
            <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Muito bom - 4 estrelas"></label>
            <input type="radio" id="star3half" name="rating" value="3.5" /><label class="half" for="star3half" title="Meh - 3.5 estrelas"></label>
            <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 estrelas"></label>
            <input type="radio" id="star2half" name="rating" value="2.5" /><label class="half" for="star2half" title="Meio ruim - 2.5 estrelas"></label>
            <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Meio ruim - 2 estrelas"></label>
            <input type="radio" id="star1half" name="rating" value="1.5" /><label class="half" for="star1half" title="Meh - 1.5 estrelas"></label>
            <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Péssimo- 1 estrelas"></label>
            <input type="radio" id="starhalf" name="rating" value="0.5" /><label class="half" for="starhalf" title="Horrível - 0.5 estrelas"></label>
        </fieldset>
        <input type="submit" value="Enviar">
    </form>
</div>