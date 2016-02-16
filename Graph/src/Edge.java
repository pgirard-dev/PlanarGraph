
public class Edge {
	private Vertice v1;
	private Vertice v2;
	/**
	 * @param v1
	 * @param v2
	 */
	public Edge(Vertice v1, Vertice v2) {
		super();
		this.v1 = v1;
		this.v2 = v2;
	}
	/**
	 * @return the v1
	 */
	public Vertice getV1() {
		return v1;
	}
	/**
	 * @param v1 the v1 to set
	 */
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}
	/**
	 * @return the v2
	 */
	public Vertice getV2() {
		return v2;
	}
	/**
	 * @param v2 the v2 to set
	 */
	public void setV2(Vertice v2) {
		this.v2 = v2;
	}
	
}
