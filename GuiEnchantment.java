import java.util.Random;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GuiEnchantment extends gb {
   private static lk w = new lk();
   private Random x = new Random();
   private ContainerEnchantment y = (ContainerEnchantment)this.d;
   public int h;
   public float i;
   public float j;
   public float k;
   public float l;
   public float m;
   public float n;
   ItemStack o;

   public GuiEnchantment(aak par1InventoryPlayer, World par2World, long par3, int par4, long par5) {
      super(new ContainerEnchantment(par1InventoryPlayer, par2World, par3, par4, par5));
   }

   public void e() {
      super.e();
   }

   protected void d() {
      this.u.b(cy.a("container.enchant"), 12, 6, 4210752);
      this.u.b(cy.a("container.inventory"), 8, this.c - 96 + 2, 4210752);
   }

   public void a() {
      super.a();
      this.D_();
   }

   protected void a(int par1, int par2, int par3) {
      super.a(par1, par2, par3);
      int i = (this.q - this.b) / 2;
      int j = (this.r - this.c) / 2;

      for (int k = 0; k < 3; k++) {
         int l = par1 - (i + 60);
         int i1 = par2 - (j + 14 + 19 * k);
         if (l >= 0 && i1 >= 0 && l < 108 && i1 < 19 && this.y.a(this.p.h, k)) {
            this.p.c.a(this.y.f, k);
         }
      }
   }

   protected void a(float par1, int par2, int par3) {
      int i = this.p.p.b("/gui/enchant.png");
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.p.p.b(i);
      int j = (this.q - this.b) / 2;
      int k = (this.r - this.c) / 2;
      this.b(j, k, 0, 0, this.b, this.c);
      GL11.glPushMatrix();
      GL11.glMatrixMode(5889);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      agd scaledresolution = new agd(this.p.A, this.p.d, this.p.e);
      GL11.glViewport(
         (scaledresolution.a() - 320) / 2 * scaledresolution.c,
         (scaledresolution.b() - 240) / 2 * scaledresolution.c,
         320 * scaledresolution.c,
         240 * scaledresolution.c
      );
      GL11.glTranslatef(-0.34F, 0.23F, 0.0F);
      GLU.gluPerspective(90.0F, 1.333333F, 9.0F, 80.0F);
      float f = 1.0F;
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      tf.b();
      GL11.glTranslatef(0.0F, 3.3F, -16.0F);
      GL11.glScalef(f, f, f);
      float f1 = 5.0F;
      GL11.glScalef(f1, f1, f1);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      this.p.p.b(this.p.p.b("/item/book.png"));
      GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
      float f2 = this.n + (this.m - this.n) * par1;
      GL11.glTranslatef((1.0F - f2) * 0.2F, (1.0F - f2) * 0.1F, (1.0F - f2) * 0.25F);
      GL11.glRotatef(-(1.0F - f2) * 90.0F - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      float f3 = this.j + (this.i - this.j) * par1 + 0.25F;
      float f4 = this.j + (this.i - this.j) * par1 + 0.75F;
      f3 = (f3 - MathHelper.b((double)f3)) * 1.6F - 0.3F;
      f4 = (f4 - MathHelper.b((double)f4)) * 1.6F - 0.3F;
      if (f3 < 0.0F) {
         f3 = 0.0F;
      }

      if (f4 < 0.0F) {
         f4 = 0.0F;
      }

      if (f3 > 1.0F) {
         f3 = 1.0F;
      }

      if (f4 > 1.0F) {
         f4 = 1.0F;
      }

      GL11.glEnable(32826);
      w.a(null, 0.0F, f3, f4, f2, 0.0F, 0.0625F);
      GL11.glDisable(32826);
      tf.a();
      GL11.glMatrixMode(5889);
      GL11.glViewport(0, 0, this.p.d, this.p.e);
      GL11.glPopMatrix();
      GL11.glMatrixMode(5888);
      GL11.glPopMatrix();
      tf.a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.p.p.b(i);
      gy.a.a(this.y.b);

      for (int l = 0; l < 3; l++) {
         String s = gy.a.a();
         this.g = 0.0F;
         this.p.p.b(i);
         int i1 = this.y.c[l];
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         if (i1 == 0) {
            this.b(j + 60, k + 14 + 19 * l, 0, 185, 108, 19);
         } else {
            String s1 = "" + i1;
            nl fontrenderer = this.p.r;
            int j1 = 6839882;
            if (this.p.h.aU < i1 && !this.p.h.aT.d) {
               this.b(j + 60, k + 14 + 19 * l, 0, 185, 108, 19);
               fontrenderer.a(s, j + 62, k + 16 + 19 * l, 104, (j1 & 16711422) >> 1);
               fontrenderer = this.p.q;
               j1 = 4226832;
               fontrenderer.a(s1, j + 62 + 104 - fontrenderer.a(s1), k + 16 + 19 * l + 7, j1);
            } else {
               int k1 = par2 - (j + 60);
               int l1 = par3 - (k + 14 + 19 * l);
               if (k1 >= 0 && l1 >= 0 && k1 < 108 && l1 < 19) {
                  this.b(j + 60, k + 14 + 19 * l, 0, 204, 108, 19);
                  j1 = 16777088;
               } else {
                  this.b(j + 60, k + 14 + 19 * l, 0, 166, 108, 19);
               }

               fontrenderer.a(s, j + 62, k + 16 + 19 * l, 104, j1);
               fontrenderer = this.p.q;
               j1 = 8453920;
               fontrenderer.a(s1, j + 62 + 104 - fontrenderer.a(s1), k + 16 + 19 * l + 7, j1);
            }
         }
      }
   }

   public void D_() {
      ItemStack itemstack = this.d.b(0).b();
      if (!ItemStack.b(itemstack, this.o)) {
         this.o = itemstack;

         do {
            this.k = this.k + (this.x.nextInt(4) - this.x.nextInt(4));
         } while (this.i <= this.k + 1.0F && this.i >= this.k - 1.0F);
      }

      this.h++;
      this.j = this.i;
      this.n = this.m;
      boolean flag = false;

      for (int i = 0; i < 3; i++) {
         if (this.y.c[i] != 0) {
            flag = true;
         }
      }

      if (flag) {
         this.m += 0.2F;
      } else {
         this.m -= 0.2F;
      }

      if (this.m < 0.0F) {
         this.m = 0.0F;
      }

      if (this.m > 1.0F) {
         this.m = 1.0F;
      }

      float f = (this.k - this.i) * 0.4F;
      float f1 = 0.2F;
      if (f < -f1) {
         f = -f1;
      }

      if (f > f1) {
         f = f1;
      }

      this.l = this.l + (f - this.l) * 0.9F;
      this.i = this.i + this.l;
   }
}
