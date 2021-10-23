package mx.tecnm.tepic.ladm_u2_practica1_presentaciondiademuertos

import android.graphics.*
import android.os.CountDownTimer
import android.view.View

class Lienzo(p: MainActivity) : View(p){
    val principal = p
    val esqueleto = BitmapFactory.decodeResource(principal.resources,R.drawable.mexicano)
    val tumba = BitmapFactory.decodeResource(principal.resources,R.drawable.tumba)
    val pastopeque = BitmapFactory.decodeResource(principal.resources,R.drawable.pastop)
    val fantap = BitmapFactory.decodeResource(principal.resources,R.drawable.fantasmasp)
    val dostp = BitmapFactory.decodeResource(principal.resources,R.drawable.dostumbasp)
    val tumv = BitmapFactory.decodeResource(principal.resources,R.drawable.tumbitavela)


    var posX = 1950f
    var bandera = false

    val movimientoEsqueleto = object : CountDownTimer(2000,80){
        override fun onTick(p0: Long) {
            if (bandera == false){
                posX -= 5
                invalidate() /*para que todo se vuelva a pintar*/
                if (posX < -50){
                    bandera = true
                }
            }
            else {
                if(posX <= 1950){
                    posX += 5
                    invalidate()
                }else{
                    bandera = false
                }
            }
        }

        override fun onFinish() {
            start()
        }
    }

    init {
        movimientoEsqueleto.start()
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint();
        c.drawColor(Color.rgb(26, 82, 118));
        //montaña
        p.color = Color.rgb(25, 111, 61)
        p.style = Paint.Style.FILL
        c.drawOval(-900f,500f,2500f,1300f,p);
        p.style = Paint.Style.STROKE
        p.strokeWidth = 4.0f
        p.color = Color.rgb(25, 111, 61)
        c.drawOval(-900f,500f,2500f,1300f,p);

        c.drawBitmap(pastopeque,250f,540f,p)
        c.drawBitmap(dostp,20f,600f,p)
        c.drawBitmap(dostp,1990f,650f,p)
        c.drawBitmap(tumv,2005f,580f,p)
        c.drawBitmap(tumv,20f,500f,p)
        c.drawBitmap(pastopeque,425f,680f,p)
        c.drawBitmap(pastopeque,825f,740f,p)
        c.drawBitmap(dostp,1200f,650f,p)


        //arbol1 izq
        p.color = Color.rgb(180,114,20)
        p.style = Paint.Style.FILL
        c.drawRect(150f,350f,200f,700f,p);
        p.color = Color.rgb(20, 90, 50 )
        c.drawOval (50f, 330f, 300f, 620f, p);
        c. drawOval (60f, 260f, 290F, 550f,p);

        c.drawBitmap(tumba,350f,500f,p)
        c.drawBitmap(tumba,530f,470f,p)
        c.drawBitmap(tumba,1150f,450f,p)
        c.drawBitmap(tumba,1430f,480f,p)

        //arbol2 izq
        p.color = Color.rgb(180,114,20)
        p.style = Paint.Style.FILL
        c.drawRect(450f,350f,500f,600f,p);
        p.color = Color.rgb(20, 90, 50 )
        c.drawOval (400f, 300f, 550f, 520f, p);

        c.drawBitmap(pastopeque,1580f,540f,p)
        c.drawBitmap(tumv,1200f,500f,p)

        //arbol1 der
        p.color = Color.rgb(180,114,20)
        c.drawRect (1050f,300f, 1100f, 550f, p)
        p.color = Color.rgb(20, 90, 50 )
        c.drawOval (1000f, 250f, 1150f, 500f, p)

        c.drawBitmap(fantap,600f,620f,p)
        c.drawBitmap(fantap,1770f,580f,p)
        c.drawBitmap(fantap,200f,690f,p)
        c.drawBitmap(fantap,1100f,570f,p)

        //arbol2 der
        p.color = Color.rgb(180,114,20)
        c.drawRect (1300f,600f, 1350f, 750f, p)
        p.color = Color.rgb(20, 90, 50 )
        c.drawOval (1250f, 480f, 1400f, 650f, p)
        c.drawOval(1250f,380f,1400f,570f,p)

        //arbol3 der
        p.color = Color.rgb(180,114,20)
        c.drawRect (1700f,400f, 1750f, 600f, p)
        p.color = Color.rgb(20, 90, 50 )
        c.drawOval (1650f, 360f, 1800f, 550f, p)

        //arbol4 der
        p.color = Color.rgb(180,114,20)
        c.drawRect (1900f,500f, 1950f, 800f, p)
        p.color = Color.rgb(20, 90, 50 )
        c.drawOval (1850f, 460f, 2000f, 750f, p)

        //iglesia
        p.color = Color.rgb(208, 211, 212)
        c.drawRect(650f,400f,1000f,550f,p)
        //puerta iglesia
        p.color = Color.rgb(66, 73, 73 )
        c.drawRect (790f, 470f, 860f, 550f, p)
        //pilar izq
        p.color = Color.rgb(144, 148, 151)
        c.drawRect(650f,325f,710f,550f,p)
        //pilar der
        p.color = Color.rgb(144, 148, 151)
        c.drawRect(940f,325f,1000f,550f,p)
        //techo
        p.color = Color.rgb(66, 73, 73)
        var path = Path()
        //aqui inicia el techo
        path.moveTo(830f,350f)
        path.lineTo(930f,350f)
        path.lineTo(1030f,430f)
        path.lineTo(630f,430f)
        path.lineTo(730f,350f)
        c.drawPath (path, p)
        //cruz
        p.color = Color.rgb(126, 81, 9)
        c.drawRect(810f,250f,840f,360f,p)
        p.color = Color.rgb(126, 81, 9)
        c.drawRect(790f,270f,860f,290f,p)

        c.drawBitmap(tumv,970f,550f,p)
        c.drawBitmap(dostp,680f,510f,p)


        //luna
        p. color = Color. WHITE
        c.drawCircle (100f, 100f, 90f, p)
        p.color = Color.rgb(26, 82, 118)
        c.drawCircle (125f, 90f, 80f, p)

        //nube1
        p.color = Color.rgb(121, 125, 127)
        /*circulo1 derecha nube*/
        c.drawCircle(170f,195f,55f,p)
        /*circulo2 derecha nube*/
        c.drawCircle(230f,195f,90f,p)
        /*circulo centro nube*/
        c.drawCircle(380f,195f,110f,p)
        /*circulo2 izquierda nube*/
        c.drawCircle(530f,195f,90f,p)
        /*circulo2 izquierda nube*/
        c.drawCircle(590f,195f,55f,p)

        //nube2
        p.color = Color.rgb(121, 125, 127)
        /*circulo1 derecha nube*/
        c.drawCircle(680f,150f,55f,p)//+90
        /*circulo2 derecha nube*/
        c.drawCircle(740f,150f,90f,p)//+60
        /*circulo centro nube*/
        c.drawCircle(890f,150f,110f,p)//+150
        /*circulo2 izquierda nube*/
        c.drawCircle(1040f,150f,90f,p)//+150
        /*circulo2 izquierda nube*/
        c.drawCircle(1100f,150f,55f,p)//+60

        //nube3
        p.color = Color.rgb(121, 125, 127)
        /*circulo1 derecha nube*/
        c.drawCircle(1190f,195f,55f,p)//+90
        /*circulo2 derecha nube*/
        c.drawCircle(1250f,195f,90f,p)//+60
        /*circulo centro nube*/
        c.drawCircle(1400f,195f,110f,p)//+150
        /*circulo2 izquierda nube*/
        c.drawCircle(1550f,195f,90f,p)//+150
        /*circulo2 izquierda nube*/
        c.drawCircle(1610f,195f,55f,p)//+60

        //nube4
        p.color = Color.rgb(121, 125, 127)
        /*circulo1 derecha nube*/
        c.drawCircle(1700f,150f,55f,p)//+90
        /*circulo2 derecha nube*/
        c.drawCircle(1760f,150f,90f,p)//+60
        /*circulo centro nube*/
        c.drawCircle(1910f,150f,110f,p)//+150
        /*circulo2 izquierda nube*/
        c.drawCircle(2060f,150f,90f,p)//+150
        /*circulo2 izquierda nube*/
        c.drawCircle(2120f,150f,55f,p)//+60

        c.drawBitmap(esqueleto,posX,650f,p)
    }
}