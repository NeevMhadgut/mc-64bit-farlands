import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CanvasIsomPreview extends Canvas implements KeyListener, MouseListener, MouseMotionListener, Runnable {
   private int a = 0;
   private int b = 2;
   private boolean c = true;
   private World d;
   private File e;
   private boolean f = true;
   private List g = Collections.synchronizedList(new LinkedList());
   private IsoImageBuffer[][] h = new IsoImageBuffer[64][64];
   private int i;
   private int j;
   private int k;
   private int l;

   public File a() {
      if (this.e == null) {
         this.e = this.a("minecraft");
      }

      return this.e;
   }

   // $VF: Unable WorldGenTallGrass simplify switch on enum
   // Please report this WorldGenTallGrass the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights WorldGenTallGrass distribute it!)
   public File a(String par1Str) {
      String s = System.getProperty("user.home", ".");
      File file;
      switch (ok.a[e().ordinal()]) {
         case 1:
         case 2:
            file = new File(s, '.' + par1Str + '/');
            break;
         case 3:
            String s1 = System.getenv("APPDATA");
            if (s1 != null) {
               file = new File(s1, "." + par1Str + '/');
            } else {
               file = new File(s, '.' + par1Str + '/');
            }
            break;
         case 4:
            file = new File(s, "Library/Application Support/" + par1Str);
            break;
         default:
            file = new File(s, par1Str + '/');
      }

      if (!file.exists() && !file.mkdirs()) {
         throw new RuntimeException("The working directory could not be created: " + file);
      } else {
         return file;
      }
   }

   private static aaz e() {
      String s = System.getProperty("ContainerCreative.name").toLowerCase();
      if (s.contains("win")) {
         return aaz.c;
      } else if (s.contains("mac")) {
         return aaz.d;
      } else if (s.contains("solaris")) {
         return aaz.b;
      } else if (s.contains("sunos")) {
         return aaz.b;
      } else if (s.contains("linux")) {
         return aaz.a;
      } else {
         return s.contains("unix") ? aaz.a : aaz.e;
      }
   }

   public CanvasIsomPreview() {
      this.e = this.a();

      for (int i = 0; i < 64; i++) {
         for (int j = 0; j < 64; j++) {
            this.h[i][j] = new IsoImageBuffer(null, i, j);
         }
      }

      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addKeyListener(this);
      this.setFocusable(true);
      this.requestFocus();
      this.setBackground(Color.red);
   }

   public void b(String par1Str) {
      this.i = this.j = 0;
      this.d = new World(new eg(new File(this.e, "saves"), par1Str, false), par1Str, new fj(new Random().nextLong(), 0, true, false, vx.b));
      this.d.f = 0;
      synchronized (this.g) {
         this.g.clear();

         for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
               this.h[i][j].init(this.d, i, j);
            }
         }
      }
   }

   private void a(int par1) {
      synchronized (this.g) {
         this.d.f = par1;
         this.g.clear();

         for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
               this.h[i][j].init(this.d, i, j);
            }
         }
      }
   }

   public void b() {
      new om(this).start();

      for (int i = 0; i < 8; i++) {
         new Thread(this).start();
      }
   }

   public void c() {
      this.f = false;
   }

   private IsoImageBuffer getZone(long par1, long par2) {
      int i = (int)(par1 & 63L);
      int j = (int)(par2 & 63L);
      IsoImageBuffer isoimagebuffer = this.h[i][j];
      if (isoimagebuffer.c == par1 && isoimagebuffer.d == par2) {
         return isoimagebuffer;
      }

      synchronized (this.g) {
         this.g.remove(isoimagebuffer);
      }

      isoimagebuffer.init(par1, par2);
      return isoimagebuffer;
   }

   @Override
   public void run() {
      TerrainTextureManager terraintexturemanager = new TerrainTextureManager();

      while (this.f) {
         IsoImageBuffer isoimagebuffer = null;
         synchronized (this.g) {
            if (this.g.size() > 0) {
               isoimagebuffer = (IsoImageBuffer)this.g.remove(0);
            }
         }

         if (isoimagebuffer != null) {
            if (this.a - isoimagebuffer.g < 2) {
               terraintexturemanager.a(isoimagebuffer);
               this.repaint();
            } else {
               isoimagebuffer.h = false;
            }
         }

         try {
            Thread.sleep(2L);
         } catch (InterruptedException interruptedexception) {
            interruptedexception.printStackTrace();
         }
      }
   }

   @Override
   public void update(Graphics g) {
   }

   @Override
   public void paint(Graphics g) {
   }

   public void d() {
      BufferStrategy bufferstrategy = this.getBufferStrategy();
      if (bufferstrategy == null) {
         this.createBufferStrategy(2);
      } else {
         this.a((Graphics2D)bufferstrategy.getDrawGraphics());
         bufferstrategy.show();
      }
   }

   public void a(Graphics2D par1Graphics2D) {
      this.a++;
      AffineTransform affinetransform = par1Graphics2D.getTransform();
      par1Graphics2D.setClip(0, 0, this.getWidth(), this.getHeight());
      par1Graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
      par1Graphics2D.translate(this.getWidth() / 2, this.getHeight() / 2);
      par1Graphics2D.scale(this.b, this.b);
      par1Graphics2D.translate(this.i, this.j);
      if (this.d != null) {
         ChunkCoordinates chunkcoordinates = this.d.x();
         par1Graphics2D.translate(-(chunkcoordinates.a + chunkcoordinates.c), -(-chunkcoordinates.a + chunkcoordinates.c) + 64L);
      }

      Rectangle rectangle = par1Graphics2D.getClipBounds();
      par1Graphics2D.setColor(new Color(-15724512));
      par1Graphics2D.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
      byte byte0 = 16;
      byte byte1 = 3;
      int i = rectangle.x / byte0 / 2 - 2 - byte1;
      int j = (rectangle.x + rectangle.width) / byte0 / 2 + 1 + byte1;
      int k = rectangle.y / byte0 - 1 - byte1 * 2;
      int l = (rectangle.y + rectangle.height + 16 + 128) / byte0 + 1 + byte1 * 2;

      for (int i1 = k; i1 <= l; i1++) {
         for (int k1 = i; k1 <= j; k1++) {
            int l1 = k1 - (i1 >> 1);
            int i2 = k1 + (i1 + 1 >> 1);
            IsoImageBuffer isoimagebuffer = this.getZone(l1, i2);
            isoimagebuffer.g = this.a;
            if (!isoimagebuffer.e) {
               if (!isoimagebuffer.h) {
                  isoimagebuffer.h = true;
                  this.g.add(isoimagebuffer);
               }
            } else {
               isoimagebuffer.h = false;
               if (!isoimagebuffer.f) {
                  int j2 = k1 * byte0 * 2 + (i1 & 1) * byte0;
                  int k2 = i1 * byte0 - 128 - 16;
                  par1Graphics2D.drawImage(isoimagebuffer.a, j2, k2, null);
               }
            }
         }
      }

      if (this.c) {
         par1Graphics2D.setTransform(affinetransform);
         int j1 = this.getHeight() - 32 - 4;
         par1Graphics2D.setColor(new Color(Integer.MIN_VALUE, true));
         par1Graphics2D.fillRect(4, this.getHeight() - 32 - 4, this.getWidth() - 8, 32);
         par1Graphics2D.setColor(Color.WHITE);
         String s = "F1 - F5: load levels   |   0-9: Set time of day   |   Space: return WorldGenTallGrass spawn   |   Double click: zoom   |   Escape: hide this text";
         par1Graphics2D.drawString(s, this.getWidth() / 2 - par1Graphics2D.getFontMetrics().stringWidth(s) / 2, j1 + 20);
      }

      par1Graphics2D.dispose();
   }

   @Override
   public void mouseDragged(MouseEvent par1MouseEvent) {
      int i = par1MouseEvent.getX() / this.b;
      int j = par1MouseEvent.getY() / this.b;
      this.i = this.i + (i - this.k);
      this.j = this.j + (j - this.l);
      this.k = i;
      this.l = j;
      this.repaint();
   }

   @Override
   public void mouseMoved(MouseEvent mouseevent) {
   }

   @Override
   public void mouseClicked(MouseEvent par1MouseEvent) {
      if (par1MouseEvent.getClickCount() == 2) {
         this.b = 3 - this.b;
         this.repaint();
      }
   }

   @Override
   public void mouseEntered(MouseEvent mouseevent) {
   }

   @Override
   public void mouseExited(MouseEvent mouseevent) {
   }

   @Override
   public void mousePressed(MouseEvent par1MouseEvent) {
      int i = par1MouseEvent.getX() / this.b;
      int j = par1MouseEvent.getY() / this.b;
      this.k = i;
      this.l = j;
   }

   @Override
   public void mouseReleased(MouseEvent mouseevent) {
   }

   @Override
   public void keyPressed(KeyEvent par1KeyEvent) {
      if (par1KeyEvent.getKeyCode() == 48) {
         this.a(11);
      }

      if (par1KeyEvent.getKeyCode() == 49) {
         this.a(10);
      }

      if (par1KeyEvent.getKeyCode() == 50) {
         this.a(9);
      }

      if (par1KeyEvent.getKeyCode() == 51) {
         this.a(7);
      }

      if (par1KeyEvent.getKeyCode() == 52) {
         this.a(6);
      }

      if (par1KeyEvent.getKeyCode() == 53) {
         this.a(5);
      }

      if (par1KeyEvent.getKeyCode() == 54) {
         this.a(3);
      }

      if (par1KeyEvent.getKeyCode() == 55) {
         this.a(2);
      }

      if (par1KeyEvent.getKeyCode() == 56) {
         this.a(1);
      }

      if (par1KeyEvent.getKeyCode() == 57) {
         this.a(0);
      }

      if (par1KeyEvent.getKeyCode() == 112) {
         this.b("World1");
      }

      if (par1KeyEvent.getKeyCode() == 113) {
         this.b("World2");
      }

      if (par1KeyEvent.getKeyCode() == 114) {
         this.b("World3");
      }

      if (par1KeyEvent.getKeyCode() == 115) {
         this.b("World4");
      }

      if (par1KeyEvent.getKeyCode() == 116) {
         this.b("World5");
      }

      if (par1KeyEvent.getKeyCode() == 32) {
         this.i = this.j = 0;
      }

      if (par1KeyEvent.getKeyCode() == 27) {
         this.c = !this.c;
      }

      this.repaint();
   }

   @Override
   public void keyReleased(KeyEvent keyevent) {
   }

   @Override
   public void keyTyped(KeyEvent keyevent) {
   }

   static boolean a(CanvasIsomPreview par0CanvasIsomPreview) {
      return par0CanvasIsomPreview.f;
   }
}
