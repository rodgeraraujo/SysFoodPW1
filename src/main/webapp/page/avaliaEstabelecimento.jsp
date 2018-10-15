<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 13/10/2018
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <h4 class="modal-title">Avalie o estabelecimento ${sessionScope.estabelecimento.nome}</h4>
</div>
<div class="modal-body">
    <form method="post" action="/front?action=AvaliarEstabeleciment" class="col l5 offset-l1">
        <div class="row modal-row center">
            <div class="col-sm-5 cen">
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
            </div>
        </div>
        <div class="row modal-row">
            <%--<div class="col-sm-3">--%>
                <%--<p>--%>
                    <%--<label>Comentário: </label>--%>
                <%--</p>--%>
            <%--</div>--%>
            <div class="col-sm-5">
                <textarea style="height: 100px; margin-left: 80px" class="form-control" placeholder="Comentário" name="comentario" id="comentario" cols="20" rows="10"></textarea>
            </div>
        </div>
        <br>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            <button type="submit" class="btn btn-social">Enviar Avaliação</button>
        </div>
    </form>
</div>