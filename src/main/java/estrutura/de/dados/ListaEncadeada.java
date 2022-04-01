/*
 * package estrutura.de.dados;
 * 
 * public class ListaEncadeada {
 * 
 * NoComGenerics<T> referenciaEntrada;
 * 
 * public ListaEncadeada() { this.referenciaEntrada = null; }
 * 
 * public void add(NoComGenerics novoNo){ if(this.isEmpty()){ referenciaEntrada
 * = novoNo; return; }
 * 
 * NoComGenerics<T> noAuxiliar = referenciaEntrada; for(int i=0; i
 * <this.size()-1; i++){ noAuxiliar = noAuxiliar.getProximoNo(); }
 * noAuxiliar.setProximoNo(novoNo); }
 * 
 * private void validaIndice(int index) throws IndexOutOfBoundsException{
 * if(index >= this.size()){ throw new IndexOutOfBoundsException().getCause(); }
 * }
 * 
 * //Usado só pela prórpia classe. Copia o nó, mas não o retira da lista
 * private NoComGenerics getNo(int index){ validaIndice(index); NoComGenerics
 * noAuxiliar = referenciaEntrada; NoComGenerics noRetorno = null;
 * 
 * for(int i=0; i <= index; i++){ //if(i <= index){ noRetorno = noAuxiliar;
 * noAuxiliar = noAuxiliar.getProximoNo(); //} } return noRetorno; }
 * 
 * public T get(int index){ return getNo(index).getConteúdo(); }
 * 
 * //Retorna o conteúdo do nó removido e remove-o da lista public T remove(int
 * index){ NoComGenerics noPivor = this.getNo(index); if(index == 0){
 * referenciaEntrada = noPivor.getProximoNo(); return noPivor.getConteúdo(); }
 * NoComGenerics noAnterior = getNo(index - 1);
 * noAnterior.setProximoNo(noPivor.getProximoNo()); return
 * noPivor.getConteúdo(); }
 * 
 * public int size(){ int tamanhoLista = 0; NoComGenerics<T> referenciaAux =
 * referenciaEntrada;
 * 
 * while(true){ if(referenciaAux != null){ tamanhoLista ++;
 * if(referenciaAux.getProximoNo() != null){ referenciaAux =
 * referenciaAux.getProximoNo(); } else { break; } } else { break; } } return
 * tamanhoLista; }
 * 
 * public boolean isEmpty(){ return referenciaEntrada == null? true : false; }
 * 
 * @Override public String toString(){ String str = "";
 * 
 * NoComGenerics<T> noAuxiliar = referenciaEntrada; for(i=0; i <this.size();
 * i++){ str += "No {conteúdo = " + noAuxiliar.getConteúdo() + " } ---> \n";
 * noAuxiliar = noAuxiliar.getProximoNo(); } str += " null"; return str; } }
 */
