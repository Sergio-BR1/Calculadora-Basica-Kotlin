fun main() { 
	var continua = true

	println("********************CALCULADORA************************")
  while(continua) {
  	calculadora()
		println("Digite 'S' se quiser continuar usando a calculadora, qualquer outro dígito a encerrará.")
		val resposta = readLine()
		if(resposta != "S") continua = false
	}

}


fun calcula (num1:Float,num2:Float,operation:(Float,Float)->Float) = operation(num1, num2)

fun fatorial(num: Int): Int {
	if (num == 0)  return 1
  else return (num * fatorial(num-1))
}

fun calculadora() {
	val number1: Float?
	val number2: Float? 
	val operacao: Int?
	
				
	println("Digite o primeiro número da operação")

	//Usei as auxiliares para conseguir ler e fazer a verificação de nulabilidade
	val aux = readLine()
			
	println("\nDigite o número correspondente à operação desejada")
	println("1 para soma")
	println("2 para subtração")
	println("3 para multiplicação")
	println("4 para divisão")
	println("5 para resto da divisão") 
	println("6 para potenciação")
	println("7 para raiz quadrada")
	println("8 para porcentagem")
	println("9 para fatorial")
	println("Obs: No caso de raiz quadrada ou fatorial, será usado o valor absoluto do número digitado, no fatorial, o número será convertido para inteiro")
	val aux2 = readLine()

	var aux3:String? = "0"

//Caso seja raiz quadrada ou fatorial, não lê o segundo número
	if (aux2 != "7" && aux2 != "9") {
		println("\nDigite o segundo número da operação")
		aux3 = readLine()
	}

//Caso algum seja nulo, exibe a mensagem de erro e caso não, atribui os valores às variáveis correspondentes
	if(aux == null || aux2 == null || aux3 == null) println("Um dos valores digitados é inválido. Por favor, verifique os números digitados")
	else {
		number1 = aux.toFloat()
		operacao = aux2.toInt()
	 	number2 = aux3.toFloat()
		

		if(operacao == 4 && number2 == 0.0000000F) println("Impossível dividir número por 0")
		else {
			
			when(operacao) {

					1 ->  println("$number1 + $number2 = ${ calcula(number1, number2){num1, num2 -> num1+num2} }")
					
					2 ->  println("$number1 - $number2 = ${ calcula(number1, number2){num1, num2 -> num1-num2} }")
					
					3 ->  println("$number1 X $number2 = ${ calcula(number1, number2){num1, num2 -> num1*num2} }")
					
					4 ->  println("$number1 / $number2 = ${ calcula(number1, number2){num1, num2 -> num1/num2} }")
					
					5 ->  println("resto de $number1 / $number2 = ${ calcula(number1, number2){num1, num2 -> num1%num2} }")
						
					6 ->  println(" $number1^$number2 = ${Math.pow(number1.toDouble(), number2.toDouble())}")

					7 -> println(" raiz quadrada de $number1 é ${Math.sqrt(Math.abs(number1.toDouble()) )}")

					8 -> println("$number1% de $number2 = ${number2/100*number1}")

					9 -> println("Fatorial de  ${number1.toInt()} = ${fatorial(number1.toInt())}")
						
				
			}
		}
	}
    
}


