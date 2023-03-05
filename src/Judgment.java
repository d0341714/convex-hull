import java.awt.event.MouseEvent;

public class Judgment {
	Board b;
	Board b2;
	Rand now;
	Rand[] r;
	int xlowest;
	int ylowest;
	int[] xarray = new int[100];
	int[] yarray = new int[100];
	int[] array = new int[100];
	int first = 0;
	double sumOutsideAngle = 0;
	double lastAngle = 0;
	boolean finish = false;

	public Judgment(Rand[] r) {
		this.r = r;
		b = new Board(r) {
			boolean firstRound = true;

			public void mousePressed(MouseEvent e) {
				int r2 = 0,r3 = 0, k1 = 0, k2 = 0, k3 = 0, firstpoint = 0, n = 0, repeat = 0, m = 0, pointspace = 0;
				double temp = 1000;
				double pretemp = 0;
				for (int i = 1; i < r.length; i++) {
					if (b.rand[i].y > b.rand[k1].y)
						k1 = i;
					else if (b.rand[i].y == b.rand[k1].y) {
						if (b.rand[i].x > b.rand[k1].x)
							k1 = i;
					}
				}

				for (int i = 1; i < r.length; i++) {
					if (b.rand[i].y < b.rand[k2].y)
						k2 = i;
					else if (b.rand[i].y == b.rand[k2].y) {
						if (b.rand[i].x < b.rand[k2].x)
							k2 = i;
					}
				}

				xlowest = b.rand[k1].x;
				ylowest = b.rand[k1].y;
				xarray[0] = k1;
				yarray[0] = k1;
				array[0] = k1;

				if (k1 == 0) {
					firstpoint = 1;
				}

				/*
				 * double x=Math.abs(b.rand[firstpoint].x - b.rand[k1].x);
				 * double y=Math.abs(b.rand[firstpoint].y-b.rand[k1].y); double
				 * z=Math.sqrt(x*x+y*y); double
				 * jiaodu=(Math.asin(y/z)/Math.PI*180); temp = jiaodu;
				 */
				// firstpoint++;
				for (int i = firstpoint; i < r.length; i++) {
					/*
					 * for(int j = 1 ; j <= n + 2; j++) { if(i == array[j]) {
					 * repeat = 1 ; } }
					 */
					if (b.rand[i].used == false/* repeat == 0 */ ) {
						double x = Math.abs(b.rand[i].x - b.rand[array[n]].x);
						double y = Math.abs(b.rand[i].y - b.rand[array[n]].y);
						double z = Math.sqrt(x * x + y * y);
						double jiaodu = (Math.asin(y / z) / Math.PI * 180);
						if (b.rand[array[k2]].used != true) {
							if (b.rand[array[n]].x - b.rand[i].x < 0) {
								if (b.rand[array[n]].y - b.rand[i].y > 0) {
									System.out.println("1");
								} else if (b.rand[array[n]].y - b.rand[i].y < 0) {
									jiaodu = 360 - jiaodu;
									System.out.println("4");
								}
							}

							else if (b.rand[array[n]].x - b.rand[i].x > 0) {

								if (b.rand[array[n]].y - b.rand[i].y > 0) {
									jiaodu = 180 - jiaodu;
									System.out.println("2");
								} else if (b.rand[array[n]].y - b.rand[i].y < 0) {
									jiaodu = 180 + jiaodu;
									System.out.println("3");
								}
							}

							else if (b.rand[array[n]].x - b.rand[i].x == 0) {
								jiaodu = 180;
							}

							else if (b.rand[array[n]].y - b.rand[i].y == 0) {
								jiaodu = 270;
							}
						}

						else {
							System.out.println("51561566546565   " + n + " " + b.rand[k2].x + " " + b.rand[k2].y);
							if (b.rand[array[n]].x - b.rand[i].x < 0) {
								if (b.rand[array[n]].y - b.rand[i].y > 0) {
									System.out.println("1");
								} else if (b.rand[array[n]].y - b.rand[i].y < 0) {
									jiaodu = 360 - jiaodu;
									System.out.println("4");
								}
							}

							else if (b.rand[array[n]].x - b.rand[i].x > 0) {
								if (b.rand[array[n]].y - b.rand[i].y > 0) {
									jiaodu = 180 - jiaodu;
									System.out.println("2");
								} else if (b.rand[array[n]].y - b.rand[i].y < 0) {
									jiaodu = 180 + jiaodu;
									System.out.println("3");
								}
							}

							else if (b.rand[array[n]].x - b.rand[i].x == 0) {
								jiaodu = 180 - jiaodu ;
							}

							else if (b.rand[array[n]].y - b.rand[i].y == 0) {
								jiaodu = jiaodu + 180;
							}
						}

						if (b.rand[k2].used != true) {
							if (temp > jiaodu && pretemp < jiaodu) {
								array[n + 1] = i;
								temp = jiaodu;
							}
						}

						else {
							if (r2 == 0) {
								if (temp > jiaodu && pretemp < jiaodu) {
									array[n + 1] = i;
									temp = jiaodu;
								}
								r3 = 1;
							}

							else {
								if (temp > jiaodu) {
									if (pretemp < jiaodu) {
										array[n + 1] = i;
										temp = jiaodu;
									} /*else if (i == k1) {
										array[n + 1] = i;
										temp = jiaodu;
									}*/
								}
							}

						}

						/*
						 * else if(temp < jiaodu && pretemp < temp) { array[n +
						 * 1] = i; temp = jiaodu; }
						 */
					}
					if (i == 49 && b.rand[array[0]].used != true) {
						if (b.rand[array[0]].used == true) {
							System.out.println("5465181654181896");
						}
						b.rand[array[n + 1]].used = true;
						i = firstpoint;
						m = firstpoint;
						g.drawLine(b.rand[array[n]].x, b.rand[array[n]].y, b.rand[array[n + 1]].x,
								b.rand[array[n + 1]].y);
						while (m != array[n + 1]) {
							m++;
						}
						/*
						 * double x2=Math.abs(b.rand[m].x -
						 * b.rand[array[n+1]].x); double
						 * y2=Math.abs(b.rand[m].y-b.rand[array[n+1]].y); double
						 * z2=Math.sqrt(x2*x2+y2*y2); double
						 * jiaodu2=(Math.asin(y2/z2)/Math.PI*180);
						 */
						if(r3==1)
						{
							r2 = 1;
						}
						pretemp = temp;
						temp = 1000;
						n++;
					}
					repeat = 0;
				}
				System.out.println(b.rand[array[0]].x + " " + b.rand[array[1]].x + " " + k1);

				// selectFirst(xarray,yarray);
				// g.drawLine(b.rand[array[0]].x, b.rand[array[0]].y,
				// b.rand[array[1]].x, b.rand[array[1]].y );
			}
		};
	}

	public void selectFirst(int[] xarray2, int[] yarray2) {
		int xlowest;
		int ylowest;
		int[] xpoints = null;
		int[] ypoints = null;

		int k = 0;
		for (int i = 1; i < r.length; i++) {
			if (b.rand[i].y < b.rand[k].y)
				k = i;
			else if (b.rand[i].y == b.rand[k].y) {
				if (b.rand[i].x > b.rand[k].x)
					k = i;
			}
		}
		xarray2[0] = b.rand[k].x;
		yarray2[0] = b.rand[k].y;
	}

	public void selectNext() {

	}

	public double getAngles(int x1, int y1, int x0, int y0) {
		return y0;

	}

	// 4 4 4 8
	public double checkspace(double angle, int x0, int y0, int x1, int y1) {

		return angle;
	}
}
