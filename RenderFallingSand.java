import org.lwjgl.opengl.GL11;

public class RenderFallingSand extends Render {
   private RenderBlocks a = new RenderBlocks();

   public RenderFallingSand() {
      this.g = 0.5F;
   }

   public void a(EntityFallingSand par1EntityFallingSand, double par2, double par4, double par6, float par8, float par9) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2, (float)par4, (float)par6);
      this.a("/terrain.png");
      Block block = Block.m[par1EntityFallingSand.a];
      World world = par1EntityFallingSand.n();
      GL11.glDisable(2896);
      if (block == Block.bK) {
         this.a.a = world;
         Tessellator tessellator = Tessellator.a;
         tessellator.b();
         tessellator.b(-MathHelper.d(par1EntityFallingSand.o) - 0.5, -MathHelper.c(par1EntityFallingSand.p) - 0.5, -MathHelper.d(par1EntityFallingSand.q) - 0.5);
         this.a.renderBlockByRenderType(block, MathHelper.d(par1EntityFallingSand.o), MathHelper.c(par1EntityFallingSand.p), MathHelper.d(par1EntityFallingSand.q));
         tessellator.b(0.0, 0.0, 0.0);
         tessellator.a();
      } else {
         this.a.renderBlockFallingSand(block, world, MathHelper.d(par1EntityFallingSand.o), MathHelper.c(par1EntityFallingSand.p), MathHelper.d(par1EntityFallingSand.q));
      }

      GL11.glEnable(2896);
      GL11.glPopMatrix();
   }

   @Override
   public void a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.a((EntityFallingSand)par1Entity, par2, par4, par6, par8, par9);
   }
}
