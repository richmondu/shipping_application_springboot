set GET_API=http://127.0.0.1:8080/api/v1/shipping/fee
set VOUCHER_CODE=skdlks

curl -X GET "%GET_API%?code=%VOUCHER_CODE%&weight=51&height=1&width=1&length=1" -H "accept: application/json"
curl -X GET "%GET_API%?code=%VOUCHER_CODE%&weight=11&height=1&width=1&length=1" -H "accept: application/json"
curl -X GET "%GET_API%?code=%VOUCHER_CODE%&weight=1&height=10&width=10&length=10" -H "accept: application/json"
curl -X GET "%GET_API%?code=%VOUCHER_CODE%&weight=1&height=20&width=10&length=10" -H "accept: application/json"
curl -X GET "%GET_API%?code=%VOUCHER_CODE%&weight=1&height=30&width=10&length=10" -H "accept: application/json"

pause

