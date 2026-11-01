import org.lwjgl.opengl.GL11;

public class RenderEnderCrystal extends Render {
   private int a = -1;
   private ho b;

   public RenderEnderCrystal() {
      this.g = 0.5F;
   }

   public void a(EntityEnderCrystal par1EntityEnderCrystal, double par2, double par4, double par6, float par8, float par9) {
      if (this.a != 1) {
         this.b = new aml(0.0F);
         this.a = 1;
      }

      float f = par1EntityEnderCrystal.a + par9;
      GL11.glPushMatrix();
      GL11.glTranslated(par2, par4, par6);
      this.a("/mob/enderdragon/crystal.png");
      float f1 = MathHelper.a(f * 0.2F) / 2.0F + 0.5F;
      f1 = f1 * f1 + f1;
      this.b.a(par1EntityEnderCrystal, 0.0F, f * 3.0F, f1 * 0.2F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   @Override
   public void a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.a((EntityEnderCrystal)par1Entity, par2, par4, par6, par8, par9);
   }
}
