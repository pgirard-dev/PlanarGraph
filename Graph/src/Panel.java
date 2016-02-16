import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel {
	// stock the vertices
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	private final int VERT_WIDTH = 10;
	private final int VERT_HEIGHT = 10;

	private Vertice grabbedVertice = null;
	private ArrayList<Edge> edges = new ArrayList<Edge>();

	private Vertice edgeConstruction = null;

	public Panel() {
		// add three vertices
		for (int i = 0; i < 3; i++)
			addVertice();

		// edges.add(new Edge(vertices.get(0), vertices.get(1)));

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

				// grab an object
				int x = e.getX();
				int y = e.getY();

				for (int i = 0; i < vertices.size(); i++) {
					int xv = vertices.get(i).getX();
					int yv = vertices.get(i).getY();

					double distance = Math.sqrt(Math.pow((x - xv), 2)
							+ Math.pow((y - yv), 2));

					if (distance <= 10) {
						// grab the vertice
						if (e.getButton() == MouseEvent.BUTTON3) {
							// if right click
							if (edgeConstruction == null) {
								edgeConstruction = vertices.get(i);
							} else {
								addEdge(edgeConstruction, vertices.get(i));
								edgeConstruction = null;
							}
						}
						grabbedVertice = vertices.get(i);
						break;
					} else {
						grabbedVertice = null;
					}

				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if (grabbedVertice != null) {
					grabbedVertice.setX(e.getX());
					grabbedVertice.setY(e.getY());
					repaint();
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {

			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		// paints the vertices
		for (int i = 0; i < vertices.size(); i++) {
			g.fillOval(vertices.get(i).getX() - VERT_WIDTH / 2, vertices.get(i)
					.getY() - VERT_HEIGHT / 2, VERT_WIDTH, VERT_HEIGHT);
		}

		// paints the edges;
		for (int i = 0; i < edges.size(); i++) {
			// draw edges between v1 and v2
			Vertice v1 = edges.get(i).getV1();
			Vertice v2 = edges.get(i).getV2();
			g.drawLine(v1.getX(), v1.getY(), v2.getX(), v2.getY());
		}
	}

	public void addVertice() {
		// TODO Auto-generated method stub
		vertices.add(new Vertice((int) (Math.random() * 100), (int) (Math
				.random() * 100)));
		repaint();
	}

	public void removeVertice() {
		try {
			vertices.remove(vertices.size() - 1);
			repaint();
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	public void addEdge(Vertice v1, Vertice v2) {
		edges.add(new Edge(v1, v2));
		repaint();
	}

	public void removeEdge() {
		try {
			edges.remove(edges.size() - 1);
			repaint();
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

}
