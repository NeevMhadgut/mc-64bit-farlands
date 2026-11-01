import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiEditSign extends vp {
   private static final String e = xn.a;
   protected String a = "Edit sign message:";
   private sc b;
   private int c;
   private int d = 0;

   public GuiEditSign(sc par1TileEntitySign) {
      this.b = par1TileEntitySign;
   }

   public void c() {
      this.s.clear();
      Keyboard.enableRepeatEvents(true);
      this.s.add(new abp(0, this.q / 2 - 100, this.r / 4 + 120, "Done"));
      this.b.a(false);
   }

   public void e() {
      Keyboard.enableRepeatEvents(false);
      if (this.p.f.F) {
         this.p.q().c(new Packet130UpdateSign(this.b.j, this.b.k, this.b.l, this.b.a));
      }

      this.b.a(true);
   }

   public void a() {
      this.c++;
   }

   protected void a(abp par1GuiButton) {
      if (par1GuiButton.h) {
         if (par1GuiButton.f == 0) {
            this.b.j();
            this.p.a((vp)null);
         }
      }
   }

   protected void a(char par1, int par2) {
      if (par2 == 200) {
         this.d = this.d - 1 & 3;
      }

      if (par2 == 208 || par2 == 28) {
         this.d = this.d + 1 & 3;
      }

      if (par2 == 14 && this.b.a[this.d].length() > 0) {
         this.b.a[this.d] = this.b.a[this.d].substring(0, this.b.a[this.d].length() - 1);
      }

      if (e.indexOf(par1) >= 0 && this.b.a[this.d].length() < 15) {
         this.b.a[this.d] = this.b.a[this.d] + par1;
      }
   }

   public void a(int par1, int par2, float par3) {
      this.k();
      this.a(this.u, this.a, this.q / 2, 40, 16777215);
      GL11.glPushMatrix();
      GL11.glTranslatef(this.q / 2, 0.0F, 50.0F);
      float f = 93.75F;
      GL11.glScalef(-f, -f, -f);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      Block block = this.b.k();
      if (block == Block.aD) {
         float f1 = this.b.i() * 360 / 16.0F;
         GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
      } else {
         int i = this.b.i();
         float f2 = 0.0F;
         if (i == 2) {
            f2 = 180.0F;
         }

         if (i == 4) {
            f2 = 90.0F;
         }

         if (i == 5) {
            f2 = -90.0F;
         }

         GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
      }

      if (this.c / 6 % 2 == 0) {
         this.b.b = this.d;
      }

      TileEntityRenderer.a.a(this.b, -0.5, -0.75, -0.5, 0.0F);
      this.b.b = -1;
      GL11.glPopMatrix();
      super.a(par1, par2, par3);
   }
}
