import org.lwjgl.opengl.GL11;

public class RenderEnchantmentTable extends aar {
   private lk a = new lk();

   public void a(TileEntityEnchantmentTable par1TileEntityEnchantmentTable, double par2, double par4, double par6, float par8) {
      GL11.glPushMatrix();
      GL11.glTranslated(par2 + 0.5, par4 + 0.75, par6 + 0.5);
      float f = par1TileEntityEnchantmentTable.a + par8;
      GL11.glTranslatef(0.0F, 0.1F + MathHelper.a(f * 0.1F) * 0.01F, 0.0F);
      float f1 = par1TileEntityEnchantmentTable.h - par1TileEntityEnchantmentTable.p;

      while (f1 >= (float) Math.PI) {
         f1 -= (float) (Math.PI * 2);
      }

      while (f1 < (float) -Math.PI) {
         f1 += (float) (Math.PI * 2);
      }

      float f2 = par1TileEntityEnchantmentTable.p + f1 * par8;
      GL11.glRotatef(-f2 * 180.0F / (float) Math.PI, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
      this.a("/item/book.png");
      float f3 = par1TileEntityEnchantmentTable.c + (par1TileEntityEnchantmentTable.b - par1TileEntityEnchantmentTable.c) * par8 + 0.25F;
      float f4 = par1TileEntityEnchantmentTable.c + (par1TileEntityEnchantmentTable.b - par1TileEntityEnchantmentTable.c) * par8 + 0.75F;
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

      float f5 = par1TileEntityEnchantmentTable.g + (par1TileEntityEnchantmentTable.f - par1TileEntityEnchantmentTable.g) * par8;
      this.a.a(null, f, f3, f4, f5, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   public void a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      this.a((TileEntityEnchantmentTable)par1TileEntity, par2, par4, par6, par8);
   }
}
