import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderer {
   private Map m = new HashMap();
   public static TileEntityRenderer a = new TileEntityRenderer();
   private nl n;
   public static double b;
   public static double c;
   public static double d;
   public aaw e;
   public World f;
   public EntityLiving g;
   public float h;
   public float i;
   public double j;
   public double k;
   public double l;

   private TileEntityRenderer() {
      this.m.put(sc.class, new ll());
      this.m.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
      this.m.put(TileEntityPiston.class, new TileEntityRendererPiston());
      this.m.put(TileEntityChest.class, new TileEntityChestRenderer());
      this.m.put(TileEntityEnchantmentTable.class, new RenderEnchantmentTable());
      this.m.put(bw.class, new RenderEndPortal());

      for (aar tileentityspecialrenderer : this.m.values()) {
         tileentityspecialrenderer.a(this);
      }
   }

   public aar a(Class par1Class) {
      aar tileentityspecialrenderer = (aar)this.m.get(par1Class);
      if (tileentityspecialrenderer == null && par1Class != TileEntity.class) {
         tileentityspecialrenderer = this.a(par1Class.getSuperclass());
         this.m.put(par1Class, tileentityspecialrenderer);
      }

      return tileentityspecialrenderer;
   }

   public boolean a(TileEntity par1TileEntity) {
      return this.b(par1TileEntity) != null;
   }

   public aar b(TileEntity par1TileEntity) {
      return par1TileEntity == null ? null : this.a(par1TileEntity.getClass());
   }

   public void a(World par1World, aaw par2RenderEngine, nl par3FontRenderer, EntityLiving par4EntityLiving, float par5) {
      if (this.f != par1World) {
         this.a(par1World);
      }

      this.e = par2RenderEngine;
      this.g = par4EntityLiving;
      this.n = par3FontRenderer;
      this.h = par4EntityLiving.w + (par4EntityLiving.u - par4EntityLiving.w) * par5;
      this.i = par4EntityLiving.x + (par4EntityLiving.v - par4EntityLiving.x) * par5;
      this.j = par4EntityLiving.N + (par4EntityLiving.o - par4EntityLiving.N) * par5;
      this.k = par4EntityLiving.O + (par4EntityLiving.p - par4EntityLiving.O) * par5;
      this.l = par4EntityLiving.P + (par4EntityLiving.q - par4EntityLiving.P) * par5;
   }

   public void a() {
   }

   public void a(TileEntity par1TileEntity, float par2) {
      if (par1TileEntity.a(this.j, this.k, this.l) < 4096.0) {
         int i = this.f.getLightBrightnessForSkyBlocks(par1TileEntity.j, par1TileEntity.k, par1TileEntity.l, 0);
         int j = i % 65536;
         int k = i / 65536;
         es.a(es.b, j / 1.0F, k / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.a(par1TileEntity, par1TileEntity.j - b, par1TileEntity.k - c, par1TileEntity.l - d, par2);
      }
   }

   public void a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      aar tileentityspecialrenderer = this.b(par1TileEntity);
      if (tileentityspecialrenderer != null) {
         tileentityspecialrenderer.a(par1TileEntity, par2, par4, par6, par8);
      }
   }

   public void a(World par1World) {
      this.f = par1World;

      for (aar tileentityspecialrenderer : this.m.values()) {
         if (tileentityspecialrenderer != null) {
            tileentityspecialrenderer.a(par1World);
         }
      }
   }

   public nl b() {
      return this.n;
   }
}
