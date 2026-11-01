import java.util.List;

public class WorldInfo {
   private long a;
   private vx b;
   private long c;
   private int d;
   private long e;
   private long f;
   private long g;
   private long h;
   private ady i;
   private int j;
   private String k;
   private int l;
   private boolean m;
   private int n;
   private boolean o;
   private int p;
   private int q;
   private boolean r;
   private boolean s;

   public WorldInfo(ady par1NBTTagCompound) {
      this.b = vx.b;
      this.s = false;
      this.a = par1NBTTagCompound.g("RandomSeed");
      if (par1NBTTagCompound.c("generatorName")) {
         String s = par1NBTTagCompound.j("generatorName");
         this.b = vx.a(s);
         if (this.b == null) {
            this.b = vx.b;
         } else if (this.b.e()) {
            int i = 0;
            if (par1NBTTagCompound.c("generatorVersion")) {
               i = par1NBTTagCompound.f("generatorVersion");
            }

            this.b = this.b.a(i);
         }
      }

      this.q = par1NBTTagCompound.f("GameType");
      if (par1NBTTagCompound.c("MapFeatures")) {
         this.r = par1NBTTagCompound.o("MapFeatures");
      } else {
         this.r = true;
      }

      try {
         this.c = par1NBTTagCompound.g("SpawnX");
      } catch (ClassCastException ex) {
         this.c = par1NBTTagCompound.f("SpawnX");
      }

      this.d = par1NBTTagCompound.f("SpawnY");

      try {
         this.e = par1NBTTagCompound.g("SpawnZ");
      } catch (ClassCastException ex) {
         this.e = par1NBTTagCompound.f("SpawnZ");
      }

      this.f = par1NBTTagCompound.g("Time");
      this.g = par1NBTTagCompound.g("LastPlayed");
      this.h = par1NBTTagCompound.g("SizeOnDisk");
      this.k = par1NBTTagCompound.j("LevelName");
      this.l = par1NBTTagCompound.f("version");
      this.n = par1NBTTagCompound.f("rainTime");
      this.m = par1NBTTagCompound.o("raining");
      this.p = par1NBTTagCompound.f("thunderTime");
      this.o = par1NBTTagCompound.o("thundering");
      this.s = par1NBTTagCompound.o("hardcore");
      if (par1NBTTagCompound.c("Player")) {
         this.i = par1NBTTagCompound.m("Player");
         this.j = this.i.f("Dimension");
      }
   }

   public WorldInfo(fj par1WorldSettings, String par2Str) {
      this.b = vx.b;
      this.s = false;
      this.a = par1WorldSettings.a();
      this.q = par1WorldSettings.b();
      this.r = par1WorldSettings.d();
      this.k = par2Str;
      this.s = par1WorldSettings.c();
      this.b = par1WorldSettings.e();
   }

   public WorldInfo(WorldInfo par1WorldInfo) {
      this.b = vx.b;
      this.s = false;
      this.a = par1WorldInfo.a;
      this.b = par1WorldInfo.b;
      this.q = par1WorldInfo.q;
      this.r = par1WorldInfo.r;
      this.c = par1WorldInfo.c;
      this.d = par1WorldInfo.d;
      this.e = par1WorldInfo.e;
      this.f = par1WorldInfo.f;
      this.g = par1WorldInfo.g;
      this.h = par1WorldInfo.h;
      this.i = par1WorldInfo.i;
      this.j = par1WorldInfo.j;
      this.k = par1WorldInfo.k;
      this.l = par1WorldInfo.l;
      this.n = par1WorldInfo.n;
      this.m = par1WorldInfo.m;
      this.p = par1WorldInfo.p;
      this.o = par1WorldInfo.o;
      this.s = par1WorldInfo.s;
   }

   public ady a() {
      ady nbttagcompound = new ady();
      this.a(nbttagcompound, this.i);
      return nbttagcompound;
   }

   public ady a(List par1List) {
      ady nbttagcompound = new ady();
      EntityPlayer entityplayer = null;
      ady nbttagcompound1 = null;
      if (par1List.size() > 0) {
         entityplayer = (EntityPlayer)par1List.get(0);
      }

      if (entityplayer != null) {
         nbttagcompound1 = new ady();
         entityplayer.d(nbttagcompound1);
      }

      this.a(nbttagcompound, nbttagcompound1);
      return nbttagcompound;
   }

   private void a(ady par1NBTTagCompound, ady par2NBTTagCompound) {
      par1NBTTagCompound.a("RandomSeed", this.a);
      par1NBTTagCompound.a("generatorName", this.b.a());
      par1NBTTagCompound.a("generatorVersion", this.b.c());
      par1NBTTagCompound.a("GameType", this.q);
      par1NBTTagCompound.a("MapFeatures", this.r);
      par1NBTTagCompound.a("SpawnX", this.c);
      par1NBTTagCompound.a("SpawnY", this.d);
      par1NBTTagCompound.a("SpawnZ", this.e);
      par1NBTTagCompound.a("Time", this.f);
      par1NBTTagCompound.a("SizeOnDisk", this.h);
      par1NBTTagCompound.a("LastPlayed", System.currentTimeMillis());
      par1NBTTagCompound.a("LevelName", this.k);
      par1NBTTagCompound.a("version", this.l);
      par1NBTTagCompound.a("rainTime", this.n);
      par1NBTTagCompound.a("raining", this.m);
      par1NBTTagCompound.a("thunderTime", this.p);
      par1NBTTagCompound.a("thundering", this.o);
      par1NBTTagCompound.a("hardcore", this.s);
      if (par2NBTTagCompound != null) {
         par1NBTTagCompound.a("Player", par2NBTTagCompound);
      }
   }

   public long b() {
      return this.a;
   }

   public long getSpawnX() {
      return this.c;
   }

   public int d() {
      return this.d;
   }

   public long getSpawnZ() {
      return this.e;
   }

   public long f() {
      return this.f;
   }

   public long g() {
      return this.h;
   }

   public ady h() {
      return this.i;
   }

   public int i() {
      return this.j;
   }

   public void setSpawnX(long par1) {
      this.c = par1;
   }

   public void b(int par1) {
      this.d = par1;
   }

   public void setSpawnZ(long par1) {
      this.e = par1;
   }

   public void a(long par1) {
      this.f = par1;
   }

   public void a(ady par1NBTTagCompound) {
      this.i = par1NBTTagCompound;
   }

   public void setSpawnPosition(long par1, int par2, long par3) {
      this.c = par1;
      this.d = par2;
      this.e = par3;
   }

   public String j() {
      return this.k;
   }

   public void a(String par1Str) {
      this.k = par1Str;
   }

   public int k() {
      return this.l;
   }

   public void d(int par1) {
      this.l = par1;
   }

   public long l() {
      return this.g;
   }

   public boolean m() {
      return this.o;
   }

   public void a(boolean par1) {
      this.o = par1;
   }

   public int n() {
      return this.p;
   }

   public void e(int par1) {
      this.p = par1;
   }

   public boolean o() {
      return this.m;
   }

   public void b(boolean par1) {
      this.m = par1;
   }

   public int p() {
      return this.n;
   }

   public void f(int par1) {
      this.n = par1;
   }

   public int q() {
      return this.q;
   }

   public boolean r() {
      return this.r;
   }

   public boolean s() {
      return this.s;
   }

   public vx t() {
      return this.b;
   }

   public void a(vx par1WorldType) {
      this.b = par1WorldType;
   }
}
