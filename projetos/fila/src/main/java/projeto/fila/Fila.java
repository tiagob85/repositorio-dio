package projeto.fila;

public class Fila<T> {

    //Adicionado o elemento no final da fila.
    private No<T> refNoEntradaFila;

    public Fila(){
        this.refNoEntradaFila = null;
    }

    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    //Retorna o primeiro da fila
    public T first(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            while(true){
                if (primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                }
                else{
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while(true){
                if (primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }
                else{
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString(){
        String stringretorno = "";
        No noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null){
            while(true){
                stringretorno += "[No{objeto="+noAuxiliar.getObject() +"}]--->";
               // noAuxiliar = noAuxiliar.getRefNo();
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                }else{
                    stringretorno += "null";
                    break;
                }
            }
        }else{
            stringretorno = "null";
        }

        return stringretorno;
    }

}
