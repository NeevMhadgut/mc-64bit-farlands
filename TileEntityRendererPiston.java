import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPiston extends aar {
   private RenderBlocks a;

   public void a(TileEntityPiston par1TileEntityPiston, double par2, double par4, double par6, float par8) {
      Block block = Block.m[par1TileEntityPiston.a()];
      if (block != null && par1TileEntityPiston.a(par8) < 1.0F) {
         Tessellator tessellator = Tessellator.a;
         this.a("/terrain.png");
         tf.a();
         GL11.glBlendFunc(770, 771);
         GL11.glEnable(3042);
         GL11.glDisable(2884);
         if (Minecraft.t()) {
            GL11.glShadeModel(7425);
         } else {
            GL11.glShadeModel(7424);
         }

         tessellator.b();
         tessellator.b(
            par2 - par1TileEntityPiston.j + par1TileEntityPiston.b(par8),
            par4 - par1TileEntityPiston.k + par1TileEntityPiston.c(par8),
            par6 - par1TileEntityPiston.l + par1TileEntityPiston.d(par8)
         );
         tessellator.a(1, 1, 1);
         if (block == Block.BlockSnowBlock && par1TileEntityPiston.a(par8) < 0.5F) {
            this.a.renderPistonExtensionAllFaces(block, par1TileEntityPiston.j, par1TileEntityPiston.k, par1TileEntityPiston.l, false);
         } else if (par1TileEntityPiston.f() && !par1TileEntityPiston.d()) {
            Block.BlockSnowBlock.e(((BlockPistonBase)block).v());
            this.a
               .renderPistonExtensionAllFaces(
                  Block.BlockSnowBlock, par1TileEntityPiston.j, par1TileEntityPiston.k, par1TileEntityPiston.l, par1TileEntityPiston.a(par8) < 0.5F
               );
            Block.BlockSnowBlock.v();
            tessellator.b(par2 - par1TileEntityPiston.j, par4 - par1TileEntityPiston.k, par6 - par1TileEntityPiston.l);
            this.a.renderPistonBaseAllFaces(block, par1TileEntityPiston.j, par1TileEntityPiston.k, par1TileEntityPiston.l);
         } else {
            this.a.renderBlockAllFaces(block, par1TileEntityPiston.j, par1TileEntityPiston.k, par1TileEntityPiston.l);
         }

         tessellator.b(0.0, 0.0, 0.0);
         tessellator.a();
         tf.b();
      }
   }

   public void a(World par1World) {
      this.a = new RenderBlocks(par1World);
   }

   public void a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      this.a((TileEntityPiston)par1TileEntity, par2, par4, par6, par8);
   }
}
