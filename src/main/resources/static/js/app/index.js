function retrieveExchange() {
    const destination = $('#destination').val();

    $.ajax({
        type: 'GET',
        url: '/exchange?source=USD&destination=' + destination,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
    }).done(function (data) {
        const quote = data.quote.value;

        $("#exchangeRate").html(`환율 : ${quote} ${destination}/${data.source}`);
        $("#_exchangeRate").val(quote);
        console.log($("#_exchangeRate").val());
    }).fail(function (error) {
        console.error(error);
    });
}

function calculate() {
    const param = {
        exchangeRate: parseFloat($('#_exchangeRate').val().replace(/,/g, '')),
        transferAmount: $('#transferAmount').val()
    };

    if (!param.exchangeRate) {
        alert('환율은 필수 값 입니다.');
        return;
    }

    if (!param.transferAmount) {
        alert('송금액은 필수 값 입니다.');
        return;
    }

    $.ajax({
        type: 'POST',
        url: '/exchange/recipient/amount',
        dataType: 'json',
        contentType:'application/json; charset=utf-8',
        data: JSON.stringify(param)
    }).done(function(data) {
        console.log(JSON.stringify(data));
        $("#result").html(`수취금액은 ${data.recipientAmount.value} ${$('#destination').val()} 입니다.`);
    }).fail(function (error) {
        console.error(error);
    });
}
