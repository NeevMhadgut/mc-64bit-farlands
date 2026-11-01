import org.lwjgl.opengl.GL11;

public class TileEntityChestRenderer extends aar {
   private ahb a = new ahb();
   private ahb c = new ur();

   public void a(TileEntityChest par1TileEntityChest, double par2, double par4, double par6, float par8) {
      int i;
      if (par1TileEntityChest.i == null) {
         i = 0;
      } else {
         Block block = par1TileEntityChest.k();
         i = par1TileEntityChest.i();
         if (block != null && i == 0) {
            ((BlockChest)block).unifyAdjacentChests(par1TileEntityChest.i, par1TileEntityChest.j, par1TileEntityChest.k, par1TileEntityChest.l);
            i = par1TileEntityChest.i();
         }

         par1TileEntityChest.g();
      }

      if (par1TileEntityChest.b == null && par1TileEntityChest.d == null) {
         ahb modelchest;
         if (par1TileEntityChest.c == null && par1TileEntityChest.e == null) {
            modelchest = this.a;
            this.a("/item/chest.png");
         } else {
            modelchest = this.c;
            this.a("/item/largechest.png");
         }

         GL11.glPushMatrix();
         GL11.glEnable(32826);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
         GL11.glScalef(1.0F, -1.0F, -1.0F);
         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         int j = 0;
         if (i == 2) {
            j = 180;
         }

         if (i == 3) {
            j = 0;
         }

         if (i == 4) {
            j = 90;
         }

         if (i == 5) {
            j = -90;
         }

         if (i == 2 && par1TileEntityChest.c != null) {
            GL11.glTranslatef(1.0F, 0.0F, 0.0F);
         }

         if (i == 5 && par1TileEntityChest.e != null) {
            GL11.glTranslatef(0.0F, 0.0F, -1.0F);
         }

         GL11.glRotatef(j, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
         float f = par1TileEntityChest.g + (par1TileEntityChest.f - par1TileEntityChest.g) * par8;
         if (par1TileEntityChest.b != null) {
            float f1 = par1TileEntityChest.b.g + (par1TileEntityChest.b.f - par1TileEntityChest.b.g) * par8;
            if (f1 > f) {
               f = f1;
            }
         }

         if (par1TileEntityChest.d != null) {
            float f2 = par1TileEntityChest.d.g + (par1TileEntityChest.d.f - par1TileEntityChest.d.g) * par8;
            if (f2 > f) {
               f = f2;
            }
         }

         f = 1.0F - f;
         f = 1.0F - f * f * f;
         modelchest.a.f = -(f * (float) Math.PI / 2.0F);
         modelchest.a();
         GL11.glDisable(32826);
         GL11.glPopMatrix();
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   public void a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      this.a((TileEntityChest)par1TileEntity, par2, par4, par6, par8);
   }
}
