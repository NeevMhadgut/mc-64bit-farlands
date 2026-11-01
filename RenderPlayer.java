import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class RenderPlayer extends fe {
   private xg c = (xg)this.a;
   private xg d = new xg(1.0F);
   private xg i = new xg(0.5F);
   private static final String[] j = new String[]{"cloth", "chain", "iron", "diamond", "gold"};

   public RenderPlayer() {
      super(new xg(0.0F), 0.5F);
   }

   protected int a(EntityPlayer par1EntityPlayer, int par2, float par3) {
      ItemStack itemstack = par1EntityPlayer.ap.f(3 - par2);
      if (itemstack != null) {
         Item item = itemstack.a();
         if (item instanceof ql) {
            ql itemarmor = (ql)item;
            this.a("/armor/" + j[itemarmor.c] + "_" + (par2 != 2 ? 1 : 2) + ".png");
            xg modelbiped = par2 != 2 ? this.d : this.i;
            modelbiped.c.j = par2 == 0;
            modelbiped.d.j = par2 == 0;
            modelbiped.e.j = par2 == 1 || par2 == 2;
            modelbiped.f.j = par2 == 1;
            modelbiped.g.j = par2 == 1;
            modelbiped.n.j = par2 == 2 || par2 == 3;
            modelbiped.o.j = par2 == 2 || par2 == 3;
            this.a(modelbiped);
            return !itemstack.u() ? 1 : 15;
         }
      }

      return -1;
   }

   public void a(EntityPlayer par1EntityPlayer, double par2, double par4, double par6, float par8, float par9) {
      ItemStack itemstack = par1EntityPlayer.ap.b();
      this.d.s = this.i.s = this.c.s = itemstack == null ? 0 : 1;
      if (itemstack != null && par1EntityPlayer.ai() > 0) {
         aaq enumaction = itemstack.m();
         if (enumaction == aaq.d) {
            this.d.s = this.i.s = this.c.s = 3;
         } else if (enumaction == aaq.e) {
            this.d.u = this.i.u = this.c.u = true;
         }
      }

      this.d.t = this.i.t = this.c.t = par1EntityPlayer.V();
      double d = par4 - par1EntityPlayer.H;
      if (par1EntityPlayer.V() && !(par1EntityPlayer instanceof EntityPlayerSP)) {
         d -= 0.125;
      }

      super.a(par1EntityPlayer, par2, d, par6, par8, par9);
      this.d.u = this.i.u = this.c.u = false;
      this.d.t = this.i.t = this.c.t = false;
      this.d.s = this.i.s = this.c.s = 0;
   }

   protected void a(EntityPlayer par1EntityPlayer, double par2, double par4, double par6) {
      if (Minecraft.r() && par1EntityPlayer != this.e.h) {
         float f = 1.6F;
         float f1 = 0.01666667F * f;
         float f2 = par1EntityPlayer.e(this.e.h);
         float f3 = par1EntityPlayer.V() ? 32.0F : 64.0F;
         if (f2 < f3) {
            String s = par1EntityPlayer.aA;
            if (!par1EntityPlayer.V()) {
               if (par1EntityPlayer.TileEntityDispenser()) {
                  this.a(par1EntityPlayer, s, par2, par4 - 1.5, par6, 64);
               } else {
                  this.a(par1EntityPlayer, s, par2, par4, par6, 64);
               }
            } else {
               nl fontrenderer = this.a();
               GL11.glPushMatrix();
               GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 2.3F, (float)par6);
               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-this.e.i, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(this.e.j, 1.0F, 0.0F, 0.0F);
               GL11.glScalef(-f1, -f1, f1);
               GL11.glDisable(2896);
               GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
               GL11.glDepthMask(false);
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               Tessellator tessellator = Tessellator.a;
               GL11.glDisable(3553);
               tessellator.b();
               int i = fontrenderer.a(s) / 2;
               tessellator.a(0.0F, 0.0F, 0.0F, 0.25F);
               tessellator.a(-i - 1, -1.0, 0.0);
               tessellator.a(-i - 1, 8.0, 0.0);
               tessellator.a(i + 1, 8.0, 0.0);
               tessellator.a(i + 1, -1.0, 0.0);
               tessellator.a();
               GL11.glEnable(3553);
               GL11.glDepthMask(true);
               fontrenderer.b(s, -fontrenderer.a(s) / 2, 0, 553648127);
               GL11.glEnable(2896);
               GL11.glDisable(3042);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glPopMatrix();
            }
         }
      }
   }

   protected void a(EntityPlayer par1EntityPlayer, float par2) {
      super.b(par1EntityPlayer, par2);
      ItemStack itemstack = par1EntityPlayer.ap.f(3);
      if (itemstack != null && itemstack.a().bQ < 256) {
         GL11.glPushMatrix();
         this.c.c.c(0.0625F);
         if (RenderBlocks.a(Block.m[itemstack.c].d())) {
            float f = 0.625F;
            GL11.glTranslatef(0.0F, -0.25F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(f, -f, f);
         }

         this.e.f.a(par1EntityPlayer, itemstack, 0);
         GL11.glPopMatrix();
      }

      if (par1EntityPlayer.aA.equals("deadmau5") && this.a(par1EntityPlayer.Z, null)) {
         for (int i = 0; i < 2; i++) {
            float f1 = par1EntityPlayer.w
               + (par1EntityPlayer.u - par1EntityPlayer.w) * par2
               - (par1EntityPlayer.be + (par1EntityPlayer.bd - par1EntityPlayer.be) * par2);
            float f2 = par1EntityPlayer.x + (par1EntityPlayer.v - par1EntityPlayer.x) * par2;
            GL11.glPushMatrix();
            GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.375F * (i * 2 - 1), 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.375F, 0.0F);
            GL11.glRotatef(-f2, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-f1, 0.0F, 1.0F, 0.0F);
            float f7 = 1.333333F;
            GL11.glScalef(f7, f7, f7);
            this.c.a(0.0625F);
            GL11.glPopMatrix();
         }
      }

      if (this.a(par1EntityPlayer.aC, null)) {
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, 0.0F, 0.125F);
         double d = par1EntityPlayer.aE
            + (par1EntityPlayer.aH - par1EntityPlayer.aE) * par2
            - (par1EntityPlayer.l + (par1EntityPlayer.o - par1EntityPlayer.l) * par2);
         double d1 = par1EntityPlayer.aF
            + (par1EntityPlayer.aI - par1EntityPlayer.aF) * par2
            - (par1EntityPlayer.m + (par1EntityPlayer.p - par1EntityPlayer.m) * par2);
         double d2 = par1EntityPlayer.aG
            + (par1EntityPlayer.aJ - par1EntityPlayer.aG) * par2
            - (par1EntityPlayer.n + (par1EntityPlayer.q - par1EntityPlayer.n) * par2);
         float f10 = par1EntityPlayer.be + (par1EntityPlayer.bd - par1EntityPlayer.be) * par2;
         double d3 = MathHelper.a(f10 * (float) Math.PI / 180.0F);
         double d4 = -MathHelper.b(f10 * (float) Math.PI / 180.0F);
         float f12 = (float)d1 * 10.0F;
         if (f12 < -6.0F) {
            f12 = -6.0F;
         }

         if (f12 > 32.0F) {
            f12 = 32.0F;
         }

         float f13 = (float)(d * d3 + d2 * d4) * 100.0F;
         float f14 = (float)(d * d4 - d2 * d3) * 100.0F;
         if (f13 < 0.0F) {
            f13 = 0.0F;
         }

         float f15 = par1EntityPlayer.aw + (par1EntityPlayer.EntityAIAttackOnCollide - par1EntityPlayer.aw) * par2;
         f12 += MathHelper.a((par1EntityPlayer.K + (par1EntityPlayer.L - par1EntityPlayer.K) * par2) * 6.0F) * 32.0F * f15;
         if (par1EntityPlayer.V()) {
            f12 += 25.0F;
         }

         GL11.glRotatef(6.0F + f13 / 2.0F + f12, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(f14 / 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-f14 / 2.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         this.c.b(0.0625F);
         GL11.glPopMatrix();
      }

      ItemStack itemstack1 = par1EntityPlayer.ap.b();
      if (itemstack1 != null) {
         GL11.glPushMatrix();
         this.c.f.c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         if (par1EntityPlayer.aZ != null) {
            itemstack1 = new ItemStack(Item.D);
         }

         aaq enumaction = null;
         if (par1EntityPlayer.ai() > 0) {
            enumaction = itemstack1.m();
         }

         if (itemstack1.c < 256 && RenderBlocks.a(Block.m[itemstack1.c].d())) {
            float f3 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            f3 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(f3, -f3, f3);
         } else if (itemstack1.c == Item.k.bQ) {
            float f4 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(f4, -f4, f4);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if (Item.e[itemstack1.c].a()) {
            float f5 = 0.625F;
            if (Item.e[itemstack1.c].A_()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            if (par1EntityPlayer.ai() > 0 && enumaction == aaq.d) {
               GL11.glTranslatef(0.05F, 0.0F, -0.1F);
               GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
            GL11.glScalef(f5, -f5, f5);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            float f6 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(f6, f6, f6);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         if (itemstack1.a().c()) {
            for (int j = 0; j <= 1; j++) {
               int k = itemstack1.a().b(itemstack1.i(), j);
               float f8 = (k >> 16 & 0xFF) / 255.0F;
               float f9 = (k >> 8 & 0xFF) / 255.0F;
               float f11 = (k & 0xFF) / 255.0F;
               GL11.glColor4f(f8, f9, f11, 1.0F);
               this.e.f.a(par1EntityPlayer, itemstack1, j);
            }
         } else {
            int k = itemstack1.a().b(itemstack1.i(), 0);
            float f8 = (k >> 16 & 0xFF) / 255.0F;
            float f9 = (k >> 8 & 0xFF) / 255.0F;
            float f11 = (k & 0xFF) / 255.0F;
            GL11.glColor4f(f8, f9, f11, 1.0F);
            this.e.f.a(par1EntityPlayer, itemstack1, 0);
         }

         GL11.glPopMatrix();
      }
   }

   protected void b(EntityPlayer par1EntityPlayer, float par2) {
      float f = 0.9375F;
      GL11.glScalef(f, f, f);
   }

   public void b() {
      this.c.h = 0.0F;
      this.c.a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
      this.c.f.a(0.0625F);
   }

   protected void b(EntityPlayer par1EntityPlayer, double par2, double par4, double par6) {
      if (par1EntityPlayer.M() && par1EntityPlayer.TileEntityDispenser()) {
         super.a(par1EntityPlayer, par2 + par1EntityPlayer.aM, par4 + par1EntityPlayer.aN, par6 + par1EntityPlayer.aO);
      } else {
         super.a(par1EntityPlayer, par2, par4, par6);
      }
   }

   protected void a(EntityPlayer par1EntityPlayer, float par2, float par3, float par4) {
      if (par1EntityPlayer.M() && par1EntityPlayer.TileEntityDispenser()) {
         GL11.glRotatef(par1EntityPlayer.StructureNetherBridgeStart(), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.a(par1EntityPlayer), 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
      } else {
         super.a(par1EntityPlayer, par2, par3, par4);
      }
   }

   protected void b(EntityLiving par1EntityLiving, double par2, double par4, double par6) {
      this.a((EntityPlayer)par1EntityLiving, par2, par4, par6);
   }

   protected void a(EntityLiving par1EntityLiving, float par2) {
      this.b((EntityPlayer)par1EntityLiving, par2);
   }

   protected int b(EntityLiving par1EntityLiving, int par2, float par3) {
      return this.a((EntityPlayer)par1EntityLiving, par2, par3);
   }

   protected void b(EntityLiving par1EntityLiving, float par2) {
      this.a((EntityPlayer)par1EntityLiving, par2);
   }

   protected void a(EntityLiving par1EntityLiving, float par2, float par3, float par4) {
      this.a((EntityPlayer)par1EntityLiving, par2, par3, par4);
   }

   protected void a(EntityLiving par1EntityLiving, double par2, double par4, double par6) {
      this.b((EntityPlayer)par1EntityLiving, par2, par4, par6);
   }

   public void a(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
      this.a((EntityPlayer)par1EntityLiving, par2, par4, par6, par8, par9);
   }

   public void a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.a((EntityPlayer)par1Entity, par2, par4, par6, par8, par9);
   }
}
