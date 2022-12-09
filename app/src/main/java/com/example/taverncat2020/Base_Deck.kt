package com.example.taverncat2020

import kotlin.random.Random

class Cards(Players: ArrayList<String>, Mode: Array<Int>) {
        private val drink= arrayListOf(
                "Todos os homens bebem 2 golos.",
                "Todas as mulheres bebem 2 golos.",
                "Se já fodeste á frente de uma terceira pessoa bebe 4 golos.",
                "Quem teve sexo mais recentemente dá 6 golos a quem quiser.",
                "Quem já fodeu na praia beba 3 golos",
                "Todos os afilhados do doutor Vasco bebem 4 golos.",
                "Se já comeram uma gorda bebam 3 golos.",
                "Bebam um golo por cada praxe de sap a que foram este ano.",
                "O jogador mais alto distrubui 5 golos.",
                "Todos os jogadores da área das engenharias bebem 3 golos.",
                "Todos os jogadores da área das humanidades bebem 3 golos.",
                "Todos os jogadores que já escreveram código bebem 4 golos."+"\n"+" Olá Mundo !",
                "O ultimo jogador que teve sexo pode distrubuir 5 golos.",
                "Ultimo jogador a tocar na mesa bebe 4 golos!",
                "Se já adormeceste durante o coito acaba a bebida!",
                "Se achas que fazes um bom gin soda bebe 3 golos!",
                "Se ainda não terminaste a licenciatura bebe 7 golos.",
                "Todos os jogadores que já tiveram sexo com alguém no primeiro encontro bebem 2 golos.",
                "Se tens sentimentos por uma/um ex bebe o copo todo."+"\n"+ "Just let go Bro. ",
                "Se já dormiste com mais de 5 pessoas bebe 4 golos.",
                "Se já roubaste um sinal de trânsito bebe 3 golos. Patife!",
                "Se tens vestida uma peça de roupa preta bebe 3 golos.",
                "O jogador mais sóbrio têm que terminar a bebida do mais animado."+"\n"+"Down you go.",
                "Todos os jogadores solteiros bebem 2 golos.",
                "Todos os jogadores numa relação bebem 5 golos.",
                "Bebe um golo por cada país visitado.",
                "Se já terminaste uma relação via mensagem bebe 4 golos."+"\n"+"Sem vergonha!",
                "Se já foste para uma aula ressacado bebe 1 golo.",
                "Todos os jogadores dizem o signo ao mesmo tempo.\nse outo jogador partilhar o signo bebem dois golos",
                "Todos os jogadores bebem 2 golos.",
                "Quem estiver trajado bebe 4 golos.",
                "O jogador mais baixo distribui 3 golos.",
                "Todos os jogadores que já vomitaram em casa de um amigo bebem 4 golos.\n Mais 2 golos se foi a menos de um metro da casa de banho."
        )

        private val challange= arrayListOf(
                "escolhe um jogador para jogar verdade ou consequência. \nSe este recusar têm de beber 8 golos.",
                "diz algo que nunca fizeste.\nQuem o tenha feito bebe 4 golos.",
                "aponta para o céu, o ultimo a o fazer bebe 4 golos, caloiros apontam para o céu deles",
                "bebe esse copo mais depressa que a esponja, se ganhares a esponja bebe a dobrar o resto do jogo.",
                "tira uma selfie.\nQuem não aparecer na foto têm que beber 4 golos.",
                "revela o teu histórico aos outos jogadores.\nSe recusares bebe 4 golos.",
                "todos os jogadores que não te tiverem adicionado na social media bebem 2 golos.",
                "revela a ultima mensagem de um membro do sexo oposto que recebeste.\nSe recusares bebe 4 golos.",
                "se te julgas mais atrativo/a que o jogador á tua direita bebe 2 golos.",
                "revela a tua experiência alcoólica mais original.\nSe recusares termina a bebida do jogador mais próximo.",
                "desafia um jogador para braço de ferro.\nPerdedor bebe 4 golos.",
                "adivinha a cor da roupa interior do jogador á tua direita, se falhares bebe 2 golos.",
                "lambe o teu copo sensualmente.\nO jogador á tua esquerda vai julgar se foi ou não sensual.\nSe não bebe 3 golos.",
                "beija um jogador num sitio que eles queiram.\nSe recusares bebe 3 golos.",
                "mostra-nos a tua habilidade de twearking.\nSe recusares bebe 3 golos.",
                "canta Country Road.\nSe o fizeres distribui 4 golos.\"",
                "bebe 4 golos e mantém-os na boca.\nTodos os jogadores têm que te fazer rir.\n Se falharem todos eles bebem 4 golos.",
                "escolhe alguem para beber 3 golos to teu copo.\nSharing is caring.",
                "diz o nome de todas as pessoas com quem tiveste amor.\nSe recusares ou não souberes bebe meio copo,HOE.",
                "da próxima vez que precisarem de uma bebida é o jogador á esquerda que te vai servir.",
                "escolhe um jogador para jogar verdade ou consequência. \nSe este recusar têm de beber 8 golos.",
                "joga ao eu nunca, quem já fez o que fizeste bebe 4 golos!\n",
                "escolhe um jogador para jogar verdade ou consequência. \nSe este recusar têm de beber 8 golos.",
                "escolhe uma categoria, em circulo vão dizendo palavras da categoria, perdedor bebe 5 golos",
                "diz algo que nunca fizeste.\nQuem o tenha feito bebe 4 golos."
        )
        private val vote= arrayListOf(
                "Votem no jogador mais sensual.\nVencedor bebe 3 golos.",
                "Votem no jogador mais virgem\nVencedor bebe 3 golos.",
                "Votem no jogador mais provável de acabar a fazer pornografia.\n"+"Vencedor bebe 5 golos.",
                "Votem no jogador mais provável de acabar a noite perdido.\n" + "Vencedor bebe 2 golos.",
                "Votem no melhor dançarino .\n" + "Vencedor bebe 2 golos.",
                "Votem no jogador mais provável de conseguir engatar durante a noite.\n" + "Vencedor bebe 2 golos.",
                "Votem no jogador que morreria primeiro num apocalipse zombie.\n" + "Vencedor bebe 4 golos.",
                "Votem no jogador que seria convidado primeiro para um ménage.\n" + "Vencedor bebe 5 golos.",
                "Votem no jogador com mais sede.\n" + "Vencedor bebe 6 golos.",
                "Votem no primeiro jogador a morrer num filme de terror.\n" + "Vencedor bebe 3 golos.",
                "Votem no jogador com as preferências amorosas mais rascas do grupo.\n" + "Vencedor bebe 4 golos.",
                "Votem no vendedor de substâncias ilicitas do grupo .\n" + "Vencedor bebe 2 goloss.",
                "Votem no jogador que possivelmente esconde segredos na cave.\n" + "Vencedor distribui 4 golos.",
                "Votem no jogador que irá acabar casado com o seu computador.\n" + "Vencedor bebe 2 goloss.",
                "Votem no jogador mais provavel de acordar sem memórias.\n" + "Vencedor distribui 6 golos.",
                "Votem no jogador menos á vontade em mostrar emoções.\n" + "Vencedor bebe 5 golos.",
                "Votem no jogador que mais tempo passa na social media.\n" + "Vencedor bebe 2 golos.",
                "Votem no jogador mais vadio do grupo.\n" + "Vencedor bebe 3 golos.",
                "Votem no jogador com o melhor cu do grupo.\n" + "Vencedor distribui 6 golos.",
                "Votem no jogador com auto-estima mais alta.\n" + "Vencedor bebe 6 golos.",
                "Votem no jogador com o quarto mais limpo.\n" + "Vencedor bebe 3 golos.",
                "Votem no jogador que demora mais a arranjar-se.\n" + "Vencedor distribui 8 golos.",
                "Votem no jogador mais másculo.\n" + "Vencedor bebe 6 golos.",
                "Votem no jogador que irá faltar ás aulas/trabalho amanhã.\n" + "Vencedor bebe 3 golos."

        )
        private val powerUp=arrayListOf(
                "escolhe a tua alma gémea.\nSempre que um de vocês beber o outro segue!",
                "és o Dj da noite.\nEscolhe a música para dar ambiente.",
                "quem olhar para ti bebe um golo",
                "és o caneira,sempre que te olharem nos olhos bebe 3 golos",
                "sempre que falares têm que ser na forma de uma questãom, se falhares bebe um golo",
                "és o vasco, o teu toque faz beber um golo para esquecer",
                "és o pascoal, sempre que o jogador mais alto beber, bebe o dobro",
                "és o Juiz.\nCria uma lei que quando quebrada têm a punição de 3 golos.",
                "perdeste a visão! \nCobre os olhos até alguém dizer o teu nome.",
                "és a Dama da noite!\nCada jogador que não se referir a ti como tal bebe 3 golos",
                "és o feiticeiro. \nSempre que cruzares os braços, todos os outros jogadores têm que ficar quietos.\nUltimo jogador a ficar quieto bebe 3 golos.",
                "foste envenenado! \nBebe 2 golos. Para envenenar outro jogador toca-lhe na perna sem que este se aperceba",
                "és britânico.\nBebe com o mindinho esticado, sempre que te esqueceres bebe 2 golos.",
                "foste amaldiçoado.\nAdiciona um golo a cada vez que fosses beber.",
                "recebes a granada sagrada.\nPodes fazer uma única pessoa acabar a bebida ao gritar: GRANADA."
        )
        private var Players= arrayListOf<String>()
        private var Mode  : Array<Int> = emptyArray()

        init {
                this.Players = Players
                this.Mode=Mode
        }
        fun generate():  ArrayList<Card>
        {
                var randomValues = 0
                var random_support=0
                var randomplayer=0
                var Player=""
                var vote_aux=vote
                var power_aux=powerUp
                var drink_aux= drink
                var challange_aux= challange
                var lista_cartas : ArrayList<Card> = ArrayList<Card>(39)
                for( i in 0..39)
                {
                        randomValues= Random.nextInt(1, 5)
                        while(randomValues==random_support)//better randomness
                        {
                                randomValues= Random.nextInt(1, 5)
                        }
                        random_support=randomValues
                        when (randomValues) {
                                1 ->
                                {
                                        if (!drink_aux.isEmpty()){
                                        randomValues= Random.nextInt(0, drink_aux.size)
                                        var aux= Card(drink_aux.get(randomValues),1)
                                        lista_cartas.add(aux)
                                        drink_aux.removeAt(randomValues)}
                                }
                                2 ->
                                {
                                        if (!vote_aux.isEmpty()){
                                        randomValues= Random.nextInt(0, vote_aux.size)
                                        var aux= Card(vote_aux.get(randomValues),2)
                                        lista_cartas.add(aux)
                                        vote_aux.removeAt(randomValues)}
                                }
                                3 ->
                                {
                                        if (!power_aux.isEmpty()){
                                        randomValues= Random.nextInt(0, power_aux.size)
                                        randomplayer= Random.nextInt(0, Players.size)
                                        var aux= Card(Players[randomplayer]+" "+power_aux.get(randomValues),3)
                                        lista_cartas.add(aux)
                                        power_aux.removeAt(randomValues)}
                                }
                                4 ->
                                {
                                        if (!challange_aux.isEmpty()){
                                        randomValues= Random.nextInt(0, challange_aux.size)
                                        randomplayer= Random.nextInt(0, Players.size)
                                        var aux= Card(Players[randomplayer]+" "+challange_aux.get(randomValues),4)
                                        lista_cartas.add(aux)
                                        challange_aux.removeAt(randomValues)}
                                }

                                else -> { // Note the block
                                        if (!drink_aux.isEmpty()){
                                                randomValues= Random.nextInt(0, drink_aux.size)
                                                var aux= Card(drink_aux.get(randomValues),1)
                                                lista_cartas.add(aux)
                                                drink_aux.removeAt(randomValues)}
                                }
                        }

                }
                return lista_cartas
        }
}

