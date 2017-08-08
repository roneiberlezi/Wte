<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <form id="pollForm">
                    <div class="input-group">
                        <span class="input-group-addon same-size">Title</span>
                        <input class="form-control" id="title" name="title" type="text"/>
                    </div>
                    <br/>

                    <div class="input-group">
                        <span class="input-group-addon same-size">Date</span>
                        <input class="form-control" id="datePicker" name="date" type="date"/>
                    </div>
                    <br/>

                    <p id="message"/>

                    <div class="modal-footer">
                        <button class="btn btn-default">Submit</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>