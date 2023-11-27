package Lab8;

public class Test3 {

	public static void main(String[] args) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		Node J = new Node("J");
		Node K = new Node("K");
		Node L = new Node("L");
		Node M = new Node("M");
		Node N = new Node("N");
		Node O = new Node("O");
		Node P = new Node("P");
		Node Q = new Node("Q");
		Node R = new Node("R");
		Node S = new Node("S");
		Node T = new Node("T");
		Node khong = new Node("khong",0);
		Node motM = new Node("motM", 1);
		Node motQ = new Node("motQ", 1);
		Node motT = new Node("motT", 1);
		Node haiL = new Node("haiL", 2);
		Node haiP = new Node("haiP", 2);
		Node bonK = new Node("bonK", 4);
		Node bonO = new Node("bonO", 4);
		Node bonS = new Node("bonS", 4);
		Node baR = new Node("baR", 3);
		Node baT = new Node("baT", 3);
		Node bayN = new Node("bayN", 7);
		Node bayS = new Node("bayS", 7);
		Node tam = new Node("tam", 8);
		Node chin = new Node("chin", 9);
		Node muoi = new Node("muoi", 10);

		A.addChild(B,C,D);
		B.addChild(E,F);
		C.addChild(G,H);
		D.addChild(I,J);
		E.addChild(K,L);
		K.addChild(bonK,chin);
		L.addChild(haiL);
		F.addChild(M,N);
		M.addChild(motM,muoi);
		N.addChild(khong,bayN);
		G.addChild(O);
		O.addChild(bonO);
		H.addChild(P,Q);
		P.addChild(haiP);
		Q.addChild(motQ,tam);
		I.addChild(R,S);
		R.addChild(baR);
		S.addChild(bayS,bonS);
		J.addChild(T);
		T.addChild(baT,motT);

		ISearchAlgo alphaBeta = new AlphaBetaSearchAlgo();
		System.out.println("AlphaBeta-Left To Right");
        System.out.print("Node cut: ");
		alphaBeta.execute(A);
		System.out.println("Best next move for A: " + A.getBestNextMove());
		System.out.println("=============");
		AlphaBetaRightToLeftSearchAlgo alphaBeta1 = new AlphaBetaRightToLeftSearchAlgo();
		
		System.out.println("AlphaBeta-Right To Left");
        System.out.print("Node cut: ");
		alphaBeta1.execute(A);
		System.out.println("Best next move for A: " + A.getBestNextMove());

	}

}