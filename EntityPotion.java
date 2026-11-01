import java.util.List;

public class EntityPotion extends EntityThrowable {
   private int d;

   public EntityPotion(World par1World) {
      super(par1World);
   }

   public EntityPotion(World par1World, EntityLiving par2EntityLiving, int par3) {
      super(par1World, par2EntityLiving);
      this.d = par3;
   }

   public EntityPotion(World par1World, double par2, double par4, double par6, int par8) {
      super(par1World, par2, par4, par6);
      this.d = par8;
   }

   @Override
   protected float e() {
      return 0.05F;
   }

   @Override
   protected float c() {
      return 0.5F;
   }

   @Override
   protected float d() {
      return -20.0F;
   }

   public int g() {
      return this.d;
   }

   @Override
   protected void a(MovingObjectPosition par1MovingObjectPosition) {
      if (!this.k.F) {
         List list = Item.bs.e_(this.d);
         if (list != null && !list.isEmpty()) {
            AxisAlignedBB axisalignedbb = this.y.b(4.0, 2.0, 4.0);
            List list1 = this.k.a(EntityLiving.class, axisalignedbb);
            if (list1 != null && !list1.isEmpty()) {
               for (Entity entity : list1) {
                  double d = this.f(entity);
                  if (d < 16.0) {
                     double d1 = 1.0 - Math.sqrt(d) / 4.0;
                     if (entity == par1MovingObjectPosition.g) {
                        d1 = 1.0;
                     }

                     for (alg potioneffect : list) {
                        int i = potioneffect.a();
                        if (aad.a[i].b()) {
                           aad.a[i].a(this.c, (EntityLiving)entity, potioneffect.c(), d1);
                        } else {
                           int j = (int)(d1 * potioneffect.b() + 0.5);
                           if (j > 20) {
                              ((EntityLiving)entity).b(new alg(i, j, potioneffect.c()));
                           }
                        }
                     }
                  }
               }
            }
         }

         String s1 = "iconcrack_" + Item.bs.bQ;

         for (int j1 = 0; j1 < 8; j1++) {
            this.k.a(s1, this.o, this.p, this.q, this.U.nextGaussian() * 0.15, this.U.nextDouble() * 0.2, this.U.nextGaussian() * 0.15);
         }

         int k1 = Item.bs.b(this.d, 0);
         float f = (k1 >> 16 & 0xFF) / 255.0F;
         float f1 = (k1 >> 8 & 0xFF) / 255.0F;
         float f2 = (k1 >> 0 & 0xFF) / 255.0F;
         String s2 = "spell";
         boolean instantCheck = false;
         if (Item.bs.d(this.d)) {
            s2 = "instantSpell";
            instantCheck = true;
         }

         for (int i2 = 0; i2 < 100; i2++) {
            double d16 = this.U.nextDouble() * 4.0;
            double d18 = this.U.nextDouble() * Math.PI * 2.0;
            double d20 = Math.cos(d18) * d16;
            double d22 = 0.01 + this.U.nextDouble() * 0.5;
            double d24 = Math.sin(d18) * d16;
            EntitySpellParticleFX entityfx = new EntitySpellParticleFX(this.k, this.o + d20 * 0.1, this.p + 0.3, this.q + d24 * 0.1, d20, d22, d24);
            if (instantCheck) {
               entityfx.b(144);
            }

            if (entityfx != null) {
               float f3 = 0.75F + this.U.nextFloat() * 0.25F;
               entityfx.b(f * f3, f1 * f3, f2 * f3);
               entityfx.c((float)d16);
            }
         }

         this.k.a(this.o, this.p, this.q, "random.glass", 1.0F, this.k.r.nextFloat() * 0.1F + 0.9F);
         this.A();
      }
   }
}
