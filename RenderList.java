import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

public class RenderList {
   private long a;
   private int b;
   private long c;
   private double d;
   private double e;
   private double f;
   private IntBuffer g = GLAllocation.d(65536);
   private boolean h = false;
   private boolean i = false;

   public void func_861_a(long par1, int par2, long par3, double par4, double par6, double par8) {
      this.h = true;
      ((Buffer)this.g).clear();
      this.a = par1;
      this.b = par2;
      this.c = par3;
      this.d = par4;
      this.e = par6;
      this.f = par8;
   }

   public boolean func_862_a(long par1, int par2, long par3) {
      return !this.h ? false : par1 == this.a && par2 == this.b && par3 == this.c;
   }

   public void a(int par1) {
      this.g.put(par1);
      if (this.g.remaining() == 0) {
         this.a();
      }
   }

   public void a() {
      if (this.h) {
         if (!this.i) {
            ((Buffer)this.g).flip();
            this.i = true;
         }

         if (this.g.remaining() > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(this.a - this.d), (float)(this.b - this.e), (float)(this.c - this.f));
            GL11.glCallLists(this.g);
            GL11.glPopMatrix();
         }
      }
   }

   public void b() {
      this.h = false;
      this.i = false;
   }
}
