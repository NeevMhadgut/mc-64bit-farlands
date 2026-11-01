import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class RenderManager {
   private Map o = new HashMap();
   public static RenderManager a = new RenderManager();
   private nl p;
   public static double b;
   public static double c;
   public static double d;
   public aaw e;
   public ItemRenderer f;
   public World g;
   public EntityLiving h;
   public float i;
   public float j;
   public GameSettings k;
   public double l;
   public double m;
   public double n;

   private RenderManager() {
      this.o.put(cb.class, new amo());
      this.o.put(fn.class, new amo());
      this.o.put(qr.class, new ix(new dl(), new dl(0.5F), 0.7F));
      this.o.put(cu.class, new alq(new jm(), new dj(), 0.7F));
      this.o.put(un.class, new ajh(new ze(), 0.7F));
      this.o.put(of.class, new cl(new ze(), 0.7F));
      this.o.put(yo.class, new aki(new sx(), 0.5F));
      this.o.put(rd.class, new gn(new ahp(), 0.3F));
      this.o.put(EntityOcelot.class, new sw(new mu(), 0.4F));
      this.o.put(EntitySilverfish.class, new vs());
      this.o.put(yd.class, new sv());
      this.o.put(EntityEnderman.class, new st());
      this.o.put(q.class, new afm());
      this.o.put(EntitySkeleton.class, new tg(new ie(), 0.5F));
      this.o.put(EntityBlaze.class, new qz());
      this.o.put(EntityZombie.class, new tg(new wr(), 0.5F));
      this.o.put(EntitySlime.class, new jd(new ads(16), new ads(0), 0.25F));
      this.o.put(aic.class, new aw());
      this.o.put(EntityPlayer.class, new RenderPlayer());
      this.o.put(EntityGiantZombie.class, new alz(new wr(), 0.5F, 6.0F));
      this.o.put(EntityGhast.class, new lm());
      this.o.put(EntitySquid.class, new RenderSquid(new qw(), 0.7F));
      this.o.put(EntityVillager.class, new zb());
      this.o.put(EntityIronGolem.class, new co());
      this.o.put(EntityLiving.class, new fe(new xg(), 0.5F));
      this.o.put(EntityDragon.class, new or());
      this.o.put(EntityEnderCrystal.class, new RenderEnderCrystal());
      this.o.put(Entity.class, new it());
      this.o.put(EntityPainting.class, new RenderPainting());
      this.o.put(EntityArrow.class, new iv());
      this.o.put(uq.class, new cr(Item.aD.b(0)));
      this.o.put(adw.class, new cr(Item.BiomeGenJungle.b(0)));
      this.o.put(EntityEnderEye.class, new cr(Item.bA.b(0)));
      this.o.put(qe.class, new cr(Item.aP.b(0)));
      this.o.put(EntityPotion.class, new cr(154));
      this.o.put(EntityExpBottle.class, new cr(Item.bD.b(0)));
      this.o.put(EntityFireball.class, new abu(2.0F));
      this.o.put(EntitySmallFireball.class, new abu(0.5F));
      this.o.put(EntityItem.class, new tw());
      this.o.put(EntityXPOrb.class, new tb());
      this.o.put(agg.class, new aeo());
      this.o.put(EntityFallingSand.class, new RenderFallingSand());
      this.o.put(EntityMinecart.class, new ahm());
      this.o.put(EntityBoat.class, new ea());
      this.o.put(EntityFishHook.class, new afj());
      this.o.put(d.class, new afg());

      for (Render render : this.o.values()) {
         render.a(this);
      }
   }

   public Render a(Class par1Class) {
      Render render = (Render)this.o.get(par1Class);
      if (render == null && par1Class != Entity.class) {
         render = this.a(par1Class.getSuperclass());
         this.o.put(par1Class, render);
      }

      return render;
   }

   public Render a(Entity par1Entity) {
      return this.a(par1Entity.getClass());
   }

   public void a(World par1World, aaw par2RenderEngine, nl par3FontRenderer, EntityLiving par4EntityLiving, GameSettings par5GameSettings, float par6) {
      this.g = par1World;
      this.e = par2RenderEngine;
      this.k = par5GameSettings;
      this.h = par4EntityLiving;
      this.p = par3FontRenderer;
      if (par4EntityLiving.TileEntityDispenser()) {
         int i = par1World.getBlockId(MathHelper.d(par4EntityLiving.o), MathHelper.c(par4EntityLiving.p), MathHelper.d(par4EntityLiving.q));
         if (i == Block.S.bO) {
            int j = par1World.getBlockMetadata(MathHelper.d(par4EntityLiving.o), MathHelper.c(par4EntityLiving.p), MathHelper.d(par4EntityLiving.q));
            int k = j & 3;
            this.i = k * 90 + 180;
            this.j = 0.0F;
         }
      } else {
         this.i = par4EntityLiving.w + (par4EntityLiving.u - par4EntityLiving.w) * par6;
         this.j = par4EntityLiving.x + (par4EntityLiving.v - par4EntityLiving.x) * par6;
      }

      if (par5GameSettings.E == 2) {
         this.i += 180.0F;
      }

      this.l = par4EntityLiving.N + (par4EntityLiving.o - par4EntityLiving.N) * par6;
      this.m = par4EntityLiving.O + (par4EntityLiving.p - par4EntityLiving.O) * par6;
      this.n = par4EntityLiving.P + (par4EntityLiving.q - par4EntityLiving.P) * par6;
   }

   public void a(Entity par1Entity, float par2) {
      double d = par1Entity.N + (par1Entity.o - par1Entity.N) * par2;
      double d1 = par1Entity.O + (par1Entity.p - par1Entity.O) * par2;
      double d2 = par1Entity.P + (par1Entity.q - par1Entity.P) * par2;
      float f = par1Entity.w + (par1Entity.u - par1Entity.w) * par2;
      int i = par1Entity.b(par2);
      if (par1Entity.T()) {
         i = 15728880;
      }

      int j = i % 65536;
      int k = i / 65536;
      es.a(es.b, j / 1.0F, k / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.a(par1Entity, d - b, d1 - c, d2 - RenderManager.d, f, par2);
   }

   public void a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      Render render = this.a(par1Entity);
      if (render != null) {
         render.a(par1Entity, par2, par4, par6, par8, par9);
         render.b(par1Entity, par2, par4, par6, par8, par9);
      }
   }

   public void a(World par1World) {
      this.g = par1World;
   }

   public double a(double par1, double par3, double par5) {
      double d = par1 - this.l;
      double d1 = par3 - this.m;
      double d2 = par5 - this.n;
      return d * d + d1 * d1 + d2 * d2;
   }

   public nl a() {
      return this.p;
   }
}
