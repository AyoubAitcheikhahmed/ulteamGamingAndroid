package com.banibegood.ulteam_gaming.database.game;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GameDatabaseDao_Impl implements GameDatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GameEntity> __insertionAdapterOfGameEntity;

  private final EntityInsertionAdapter<GameEntity> __insertionAdapterOfGameEntity_1;

  private final EntityDeletionOrUpdateAdapter<GameEntity> __updateAdapterOfGameEntity;

  public GameDatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGameEntity = new EntityInsertionAdapter<GameEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `games_table` (`developer`,`freetogameProfileUrl`,`gameUrl`,`genre`,`id`,`platform`,`publisher`,`releaseDate`,`shortDescription`,`thumbnail`,`title`) VALUES (?,?,?,?,nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GameEntity value) {
        if (value.getDeveloper() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDeveloper());
        }
        if (value.getFreetogameProfileUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFreetogameProfileUrl());
        }
        if (value.getGameUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGameUrl());
        }
        if (value.getGenre() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGenre());
        }
        stmt.bindLong(5, value.getId());
        if (value.getPlatform() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPlatform());
        }
        if (value.getPublisher() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPublisher());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getReleaseDate());
        }
        if (value.getShortDescription() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getShortDescription());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getThumbnail());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTitle());
        }
      }
    };
    this.__insertionAdapterOfGameEntity_1 = new EntityInsertionAdapter<GameEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `games_table` (`developer`,`freetogameProfileUrl`,`gameUrl`,`genre`,`id`,`platform`,`publisher`,`releaseDate`,`shortDescription`,`thumbnail`,`title`) VALUES (?,?,?,?,nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GameEntity value) {
        if (value.getDeveloper() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDeveloper());
        }
        if (value.getFreetogameProfileUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFreetogameProfileUrl());
        }
        if (value.getGameUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGameUrl());
        }
        if (value.getGenre() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGenre());
        }
        stmt.bindLong(5, value.getId());
        if (value.getPlatform() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPlatform());
        }
        if (value.getPublisher() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPublisher());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getReleaseDate());
        }
        if (value.getShortDescription() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getShortDescription());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getThumbnail());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTitle());
        }
      }
    };
    this.__updateAdapterOfGameEntity = new EntityDeletionOrUpdateAdapter<GameEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `games_table` SET `developer` = ?,`freetogameProfileUrl` = ?,`gameUrl` = ?,`genre` = ?,`id` = ?,`platform` = ?,`publisher` = ?,`releaseDate` = ?,`shortDescription` = ?,`thumbnail` = ?,`title` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GameEntity value) {
        if (value.getDeveloper() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDeveloper());
        }
        if (value.getFreetogameProfileUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFreetogameProfileUrl());
        }
        if (value.getGameUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGameUrl());
        }
        if (value.getGenre() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGenre());
        }
        stmt.bindLong(5, value.getId());
        if (value.getPlatform() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPlatform());
        }
        if (value.getPublisher() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPublisher());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getReleaseDate());
        }
        if (value.getShortDescription() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getShortDescription());
        }
        if (value.getThumbnail() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getThumbnail());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTitle());
        }
        stmt.bindLong(12, value.getId());
      }
    };
  }

  @Override
  public void insertAll(final GameEntity... jokes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGameEntity.insert(jokes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final GameEntity game) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGameEntity_1.insert(game);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final GameEntity game) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGameEntity.handle(game);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<GameEntity>> getAllGamesLive() {
    final String _sql = "SELECT * FROM games_table ORDER BY id DESC LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"games_table"}, false, new Callable<List<GameEntity>>() {
      @Override
      public List<GameEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDeveloper = CursorUtil.getColumnIndexOrThrow(_cursor, "developer");
          final int _cursorIndexOfFreetogameProfileUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "freetogameProfileUrl");
          final int _cursorIndexOfGameUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "gameUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPlatform = CursorUtil.getColumnIndexOrThrow(_cursor, "platform");
          final int _cursorIndexOfPublisher = CursorUtil.getColumnIndexOrThrow(_cursor, "publisher");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfShortDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "shortDescription");
          final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final List<GameEntity> _result = new ArrayList<GameEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GameEntity _item;
            final String _tmpDeveloper;
            if (_cursor.isNull(_cursorIndexOfDeveloper)) {
              _tmpDeveloper = null;
            } else {
              _tmpDeveloper = _cursor.getString(_cursorIndexOfDeveloper);
            }
            final String _tmpFreetogameProfileUrl;
            if (_cursor.isNull(_cursorIndexOfFreetogameProfileUrl)) {
              _tmpFreetogameProfileUrl = null;
            } else {
              _tmpFreetogameProfileUrl = _cursor.getString(_cursorIndexOfFreetogameProfileUrl);
            }
            final String _tmpGameUrl;
            if (_cursor.isNull(_cursorIndexOfGameUrl)) {
              _tmpGameUrl = null;
            } else {
              _tmpGameUrl = _cursor.getString(_cursorIndexOfGameUrl);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpPlatform;
            if (_cursor.isNull(_cursorIndexOfPlatform)) {
              _tmpPlatform = null;
            } else {
              _tmpPlatform = _cursor.getString(_cursorIndexOfPlatform);
            }
            final String _tmpPublisher;
            if (_cursor.isNull(_cursorIndexOfPublisher)) {
              _tmpPublisher = null;
            } else {
              _tmpPublisher = _cursor.getString(_cursorIndexOfPublisher);
            }
            final String _tmpReleaseDate;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpReleaseDate = null;
            } else {
              _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpShortDescription;
            if (_cursor.isNull(_cursorIndexOfShortDescription)) {
              _tmpShortDescription = null;
            } else {
              _tmpShortDescription = _cursor.getString(_cursorIndexOfShortDescription);
            }
            final String _tmpThumbnail;
            if (_cursor.isNull(_cursorIndexOfThumbnail)) {
              _tmpThumbnail = null;
            } else {
              _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            _item = new GameEntity(_tmpDeveloper,_tmpFreetogameProfileUrl,_tmpGameUrl,_tmpGenre,_tmpId,_tmpPlatform,_tmpPublisher,_tmpReleaseDate,_tmpShortDescription,_tmpThumbnail,_tmpTitle);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<GameEntity>> getGreater20GamesLive() {
    final String _sql = "SELECT * FROM games_table ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"games_table"}, false, new Callable<List<GameEntity>>() {
      @Override
      public List<GameEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDeveloper = CursorUtil.getColumnIndexOrThrow(_cursor, "developer");
          final int _cursorIndexOfFreetogameProfileUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "freetogameProfileUrl");
          final int _cursorIndexOfGameUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "gameUrl");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPlatform = CursorUtil.getColumnIndexOrThrow(_cursor, "platform");
          final int _cursorIndexOfPublisher = CursorUtil.getColumnIndexOrThrow(_cursor, "publisher");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfShortDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "shortDescription");
          final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final List<GameEntity> _result = new ArrayList<GameEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final GameEntity _item;
            final String _tmpDeveloper;
            if (_cursor.isNull(_cursorIndexOfDeveloper)) {
              _tmpDeveloper = null;
            } else {
              _tmpDeveloper = _cursor.getString(_cursorIndexOfDeveloper);
            }
            final String _tmpFreetogameProfileUrl;
            if (_cursor.isNull(_cursorIndexOfFreetogameProfileUrl)) {
              _tmpFreetogameProfileUrl = null;
            } else {
              _tmpFreetogameProfileUrl = _cursor.getString(_cursorIndexOfFreetogameProfileUrl);
            }
            final String _tmpGameUrl;
            if (_cursor.isNull(_cursorIndexOfGameUrl)) {
              _tmpGameUrl = null;
            } else {
              _tmpGameUrl = _cursor.getString(_cursorIndexOfGameUrl);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpPlatform;
            if (_cursor.isNull(_cursorIndexOfPlatform)) {
              _tmpPlatform = null;
            } else {
              _tmpPlatform = _cursor.getString(_cursorIndexOfPlatform);
            }
            final String _tmpPublisher;
            if (_cursor.isNull(_cursorIndexOfPublisher)) {
              _tmpPublisher = null;
            } else {
              _tmpPublisher = _cursor.getString(_cursorIndexOfPublisher);
            }
            final String _tmpReleaseDate;
            if (_cursor.isNull(_cursorIndexOfReleaseDate)) {
              _tmpReleaseDate = null;
            } else {
              _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            }
            final String _tmpShortDescription;
            if (_cursor.isNull(_cursorIndexOfShortDescription)) {
              _tmpShortDescription = null;
            } else {
              _tmpShortDescription = _cursor.getString(_cursorIndexOfShortDescription);
            }
            final String _tmpThumbnail;
            if (_cursor.isNull(_cursorIndexOfThumbnail)) {
              _tmpThumbnail = null;
            } else {
              _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            _item = new GameEntity(_tmpDeveloper,_tmpFreetogameProfileUrl,_tmpGameUrl,_tmpGenre,_tmpId,_tmpPlatform,_tmpPublisher,_tmpReleaseDate,_tmpShortDescription,_tmpThumbnail,_tmpTitle);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int numberOfGames() {
    final String _sql = "SELECT COUNT(*) FROM games_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
