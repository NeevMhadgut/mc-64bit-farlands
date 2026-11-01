import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class TileEntityMobSpawnerRenderer extends aar {
   private Map a = new HashMap();

   public void a(TileEntityMobSpawner par1TileEntityMobSpawner, double par2, double par4, double par6, float par8) {
      GL11.glPushMatrix();
      GL11.glTranslated(par2 + 0.5, par4, par6 + 0.5);
      Entity entity = (Entity)this.a.get(par1TileEntityMobSpawner.a());
      if (entity == null) {
         entity = EntityList.a(par1TileEntityMobSpawner.a(), null);
         this.a.put(par1TileEntityMobSpawner.a(), entity);
      }

      if (entity != null) {
         entity.a(par1TileEntityMobSpawner.i);
         float f = 0.4375F;
         GL11.glTranslatef(0.0F, 0.4F, 0.0F);
         GL11.glRotatef((float)(par1TileEntityMobSpawner.c + (par1TileEntityMobSpawner.b - par1TileEntityMobSpawner.c) * par8) * 10.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(0.0F, -0.4F, 0.0F);
         GL11.glScalef(f, f, f);
         entity.c(par2, par4, par6, 0.0F, 0.0F);
         RenderManager.a.a(entity, 0.0, 0.0, 0.0, 0.0F, par8);
      }

      GL11.glPopMatrix();
   }

   public void a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      this.a((TileEntityMobSpawner)par1TileEntity, par2, par4, par6, par8);
   }
}
