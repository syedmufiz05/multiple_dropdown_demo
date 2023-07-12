$(document).ready(
    function () {
        getAllrecord();
        // SUBMIT FORM
        $("#formUser").submit(function (event) {
            event.preventDefault();
            ajaxPost();
        });

        function ajaxPost() {
            // PREPARE FORM DATA
            var formData = {
                firstName: $("#firstName").val(),
                lastName: $("#lastName").val(),
                emailId: $("#emailId").val(),
                phoneNo: $("#phoneNo").val(),
                countryName: $("#countries").val(),
                stateName: $("#states").val(),
                cityName: $("#cities").val()
            }
            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "saveNewUser",
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {
                    if (result.status == "success") {
                        alert("Successfully saved!")
                        getAllrecord();
                        $("#formUser")[0].reset()
                        // console.log("Successfully saved", result)
                    } else {
                        // console.log("Request failed", result)
                        alert("Request failed!")
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        function editUser(emailId) {
            $.ajax({
                type: "GET",
                url: "showFormForUpdate/" + emailId,
                dataType: 'json',
                success: function (response) {
                    //alert("student--"+response.firstName);
                    $("#firstName").val(response.firstName), $("#lastName").val(response.lastName), $(
                        "#emailId").val(response.emailId), $("#phoneNo").val(
                        response.phoneNo)
                    $('#saveStudent').hide();
                    $('#updateStudent').show();

                    // $('#idfield').show();
                    alert("button is called" + err)
                },
                error: function (err) {
                    alert("error is" + err)
                }
            });
        }

        var data = "";

        function getAllrecord() {
            $.ajax({
                type: "GET",
                url: "getAllUser",
                success: function (response) {
                    data = response

                    $('.tr').remove();
                    for (i = 0; i < data.length; i++) {
                        $("#tableUser")
                            .append(
                                '<tr class="tr"> <td>'
                                + data[i].firstName
                                + '</td> <td>'
                                + data[i].lastName
                                + '</td> <td>'
                                + data[i].emailId
                                + '</td> <td>'
                                + data[i].phoneNo
                                + '</td> <td>'
                                + data[i].countryName
                                + '</td> <td>'
                                + data[i].stateName
                                + '</td> <td>'
                                + data[i].cityName
                                + '</td></tr>');
                    }
                },
                error: function (err) {
                    alert("error is" + err)
                }
            });
        }
    })

