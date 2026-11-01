import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class EffectRenderer {
   protected World a;
   private List[] b = new List[4];
   private aaw c;
   private Random d = new Random();

   public EffectRenderer(World par1World, aaw par2RenderEngine) {
      if (par1World != null) {
         this.a = par1World;
      }

      this.c = par2RenderEngine;

      for (int i = 0; i < 4; i++) {
         this.b[i] = new ArrayList();
      }
   }

   public void a(EntityFX par1EntityFX) {
      int i = par1EntityFX.n();
      if (this.b[i].size() >= 4000) {
         this.b[i].remove(0);
      }

      this.b[i].add(par1EntityFX);
   }

   public void a() {
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < this.b[i].size(); j++) {
            EntityFX entityfx = (EntityFX)this.b[i].get(j);
            entityfx.J_();
            if (entityfx.G) {
               this.b[i].remove(j--);
            }
         }
      }
   }

   public void a(Entity par1Entity, float par2) {
      float f = ActiveRenderInfo.d;
      float f1 = ActiveRenderInfo.f;
      float f2 = ActiveRenderInfo.g;
      float f3 = ActiveRenderInfo.h;
      float f4 = ActiveRenderInfo.e;
      EntityFX.ar = par1Entity.N + (par1Entity.o - par1Entity.N) * par2;
      EntityFX.as = par1Entity.O + (par1Entity.p - par1Entity.O) * par2;
      EntityFX.at = par1Entity.P + (par1Entity.q - par1Entity.P) * par2;

      for (int i = 0; i < 3; i++) {
         if (this.b[i].size() != 0) {
            int j = 0;
            if (i == 0) {
               j = this.c.b("/particles.png");
            }

            if (i == 1) {
               j = this.c.b("/terrain.png");
            }

            if (i == 2) {
               j = this.c.b("/gui/items.png");
            }

            GL11.glBindTexture(3553, j);
            Tessellator tessellator = Tessellator.a;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tessellator.b();

            for (int k = 0; k < this.b[i].size(); k++) {
               EntityFX entityfx = (EntityFX)this.b[i].get(k);
               tessellator.b(entityfx.b(par2));
               entityfx.renderParticle(tessellator, par2, f, f4, f1, f2, f3);
            }

            tessellator.a();
         }
      }
   }

   public void b(Entity par1Entity, float par2) {
      float f = MathHelper.b(par1Entity.u * 0.01745329F);
      float f1 = MathHelper.a(par1Entity.u * 0.01745329F);
      float f2 = -f1 * MathHelper.a(par1Entity.v * 0.01745329F);
      float f3 = f * MathHelper.a(par1Entity.v * 0.01745329F);
      float f4 = MathHelper.b(par1Entity.v * 0.01745329F);
      byte byte0 = 3;
      if (this.b[byte0].size() != 0) {
         Tessellator tessellator = Tessellator.a;

         for (int i = 0; i < this.b[byte0].size(); i++) {
            EntityFX entityfx = (EntityFX)this.b[byte0].get(i);
            tessellator.b(entityfx.b(par2));
            entityfx.renderParticle(tessellator, par2, f, f4, f1, f2, f3);
         }
      }
   }

   public void a(World par1World) {
      this.a = par1World;

      for (int i = 0; i < 4; i++) {
         this.b[i].clear();
      }
   }

   public void addBlockDestroyEffects(long par1, int par2, long par3, int par4, int par5) {
      if (par4 != 0) {
         Block block = Block.m[par4];
         int i = 4;

         for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
               for (int l = 0; l < i; l++) {
                  double d = par1 + (j + 0.5) / i;
                  double d1 = par2 + (k + 0.5) / i;
                  double d2 = par3 + (l + 0.5) / i;
                  int i1 = this.d.nextInt(6);
                  this.a(new EntityDiggingFX(this.a, d, d1, d2, d - par1 - 0.5, d1 - par2 - 0.5, d2 - par3 - 0.5, block, i1, par5).func_4041_a(par1, par2, par3));
               }
            }
         }
      }
   }

   public void addBlockHitEffects(long par1, int par2, long par3, int par4) {
      int i = this.a.getBlockId(par1, par2, par3);
      if (i != 0) {
         Block block = Block.m[i];
         float f = 0.1F;
         double d = par1 + this.d.nextDouble() * (block.bY - block.bV - f * 2.0F) + f + block.bV;
         double d1 = par2 + this.d.nextDouble() * (block.bZ - block.bW - f * 2.0F) + f + block.bW;
         double d2 = par3 + this.d.nextDouble() * (block.IChunkProvider - block.bX - f * 2.0F) + f + block.bX;
         if (par4 == 0) {
            d1 = par2 + block.bW - f;
         }

         if (par4 == 1) {
            d1 = par2 + block.bZ + f;
         }

         if (par4 == 2) {
            d2 = par3 + block.bX - f;
         }

         if (par4 == 3) {
            d2 = par3 + block.IChunkProvider + f;
         }

         if (par4 == 4) {
            d = par1 + block.bV - f;
         }

         if (par4 == 5) {
            d = par1 + block.bY + f;
         }

         this.a(new EntityDiggingFX(this.a, d, d1, d2, 0.0, 0.0, 0.0, block, par4, this.a.getBlockMetadata(par1, par2, par3)).func_4041_a(par1, par2, par3).c(0.2F).d(0.6F));
      }
   }

   public String b() {
      return "" + (this.b[0].size() + this.b[1].size() + this.b[2].size());
   }
}
