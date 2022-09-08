Calendar calendar = Calendar.getInstance()
                def dia = calendar.get(Calendar.DAY_OF_WEEK)
                def diasSemana=[
                       1:"Domingo",
                       2:"Lunes",
                       3:"Martes",
                       4:"Miercoles",
                       5:"Jueves",
                       6:"Viernes",
                       7:"Sabado"]
                       
pipeline {
    agent any
    
    stages {
        stage('fecha') {
            steps {
                script{
                    def diaMes = new Date()
                    println diaMes.format('dd/MM/yyyy')
                }
            }
        }
        stage('informaticos') {
            steps {
                script{
                    if(diasSemana[dia]=="Jueves") {
                      println("¿Que le habla un bit al otro? Nos vemos en el bus")
                    }
            }
         }
      }

        
        stage('humorNegro') {
            steps {
                script{
                    if(diasSemana[dia]=="Viernes") {
                      println("¿Que hace una niña palestina en un columpio? Marear al francotirador")
                    }
                }
            }
        }
        
        stage('futbol') {
            steps {
                script{
                    if(diasSemana[dia]=="Lunes") {
                      println("Por qué Messi no bautiza a su hijo? Para no hacerse Cristiano.")
                    }
                }
            }
        }
        
        
    }
}
